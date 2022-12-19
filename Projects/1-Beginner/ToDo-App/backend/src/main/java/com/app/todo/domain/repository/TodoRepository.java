package com.app.todo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.domain.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	public List<Todo> findByDescricaoStartingWith(String comeco);

}
