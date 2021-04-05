package br.com.larissamonteiro.todolistapi.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.larissamonteiro.todolistapi.model.Task;
import br.com.larissamonteiro.todolistapi.util.TaskCreator;

@DataJpaTest
@DisplayName("Tests for Task Repository")
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DisplayName("Save creates Task when Successful")
    void save_PersistTask_WhenSuccessful(){

        Task taskToBeSaved = TaskCreator.createTaskToBeSaved();

        Task taskSaved = this.taskRepository.save(taskToBeSaved);

        Assertions.assertThat(taskSaved).isNotNull();
        Assertions.assertThat(taskSaved.getId()).isNotNull();
        Assertions.assertThat(taskSaved.getTitle()).isEqualTo(taskToBeSaved.getTitle());
    }


    @Test
    @DisplayName("Save updates Task when Successful")
    void save_UpdatesTask_WhenSuccessful(){

        Task taskToBeSaved = TaskCreator.createTaskToBeSaved();

        Task taskSaved = this.taskRepository.save(taskToBeSaved);

        taskSaved.setDescription("Sair para correr as 7:30");

        Task taskUpdated = this.taskRepository.save(taskSaved);

        Assertions.assertThat(taskUpdated).isNotNull();
        Assertions.assertThat(taskUpdated.getId()).isNotNull();
        Assertions.assertThat(taskUpdated.getTitle()).isEqualTo(taskSaved.getTitle());
    }

    @Test
    @DisplayName("Delete Task when Successful")
    void delete_Task_WhenSuccessful(){

        Task taskToBeSaved = TaskCreator.createTaskToBeSaved();

        Task taskSaved = this.taskRepository.save(taskToBeSaved);

        this.taskRepository.delete(taskSaved);
        Optional<Task> taskOptional = this.taskRepository.findById(taskSaved.getId());

        Assertions.assertThat(taskOptional.isEmpty()).isTrue();
    }


    
}