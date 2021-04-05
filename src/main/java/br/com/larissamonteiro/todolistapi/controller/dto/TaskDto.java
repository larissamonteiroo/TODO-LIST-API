package br.com.larissamonteiro.todolistapi.controller.dto;



import org.springframework.data.domain.Page;

import br.com.larissamonteiro.todolistapi.model.Task;
import br.com.larissamonteiro.todolistapi.model.TaskStatus;

public class TaskDto {

	private Long id;
	private String title;
	private String description;
	private TaskStatus status;

	public TaskDto(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.status = task.getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public static Page<TaskDto> converter(Page<Task> tasks){
		return tasks.map(TaskDto::new);
	}

}