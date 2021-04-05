package br.com.larissamonteiro.todolistapi.util;

import br.com.larissamonteiro.todolistapi.controller.dto.TaskDto;
import br.com.larissamonteiro.todolistapi.model.Task;
import br.com.larissamonteiro.todolistapi.model.TaskStatus;

public class TaskCreator {


    public static Task createTaskToBeSaved() {
        return Task.builder()
                .title("Correr")
                .description("Sair para correr as 7:00")
                .status(TaskStatus.PENDING)
                .build();
    }


    public static Task createValidTask() {
        return Task.builder()
                .title("Correr")
                .description("Sair para correr as 7:00")
                .status(TaskStatus.PENDING)
                .id(1L)
                .build();
    }


    public static Task createValidUpdatedTask() {
        return Task.builder()
                .title("Correr")
                .description("Sair para correr as 7:00")
                .status(TaskStatus.COMPLETED)
                .id(1L)
                .build();
    }
}
