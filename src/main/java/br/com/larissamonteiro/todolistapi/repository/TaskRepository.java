package br.com.larissamonteiro.todolistapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.larissamonteiro.todolistapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	Page<Task> findByTitle(String nameTask, Pageable pagination);

}
