package br.com.larissamonteiro.todolistapi.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.larissamonteiro.todolistapi.controller.dto.TaskDto;
import br.com.larissamonteiro.todolistapi.controller.form.TaskForm;
import br.com.larissamonteiro.todolistapi.model.Task;
import br.com.larissamonteiro.todolistapi.repository.TaskRepository;

@RestController
@RequestMapping("/todo")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping
	public Page<TaskDto> list(@RequestParam(required = false) String nameTask,
			@PageableDefault(page = 0, size = 10) Pageable pagination) {
		

		if (nameTask == null) {
			Page<Task> tasks = taskRepository.findAll(pagination);
			return TaskDto.converter(tasks);
		} else {
			Page<Task> tasks = taskRepository.findByTitle(nameTask, pagination);
			return TaskDto.converter(tasks);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskDto> detail(@PathVariable Long id) {
		Optional<Task> task = taskRepository.findById(id);
		if(task.isPresent()) {
			return ResponseEntity.ok(new TaskDto(task.get()));			
		}
		return ResponseEntity.notFound().build();
	}

	
	@PostMapping
	@Transactional
	public ResponseEntity<TaskDto> register(@RequestBody @Valid TaskForm form) {
		Task task = form.converter(taskRepository);
		taskRepository.save(task);

		return ResponseEntity.ok().body(new TaskDto(task));
	}

	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TaskDto> update(@PathVariable Long id, @RequestBody @Valid TaskForm form) {
		
		Optional<Task> optional = taskRepository.findById(id);
		if(optional.isPresent()) {
			Task task = form.update(id, taskRepository);
			return ResponseEntity.ok(new TaskDto(task));		
		}
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Optional<Task> optional = taskRepository.findById(id);
		if(optional.isPresent()) {
			taskRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
