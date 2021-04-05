package br.com.larissamonteiro.todolistapi.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.larissamonteiro.todolistapi.model.Task;
import br.com.larissamonteiro.todolistapi.model.TaskStatus;
import br.com.larissamonteiro.todolistapi.repository.TaskRepository;

public class TaskForm {

	@NotNull @NotBlank
	private String title;
	@NotNull
	@Size(min = 5)
	private String description;
	@NotNull 
	private TaskStatus status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Task converter(TaskRepository taskRepository) {
		return new Task(title, description, status);
	}

	public Task update(Long id, TaskRepository taskRepository) {
		Task task = taskRepository.getOne(id);
		
		task.setStatus(this.status);
		
		return task;
	}

}
