package com.app.todo.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.app.todo.domain.exception.TodoEmUsoException;
import com.app.todo.domain.exception.TodoNaoEncontradoException;
import com.app.todo.domain.model.Todo;
import com.app.todo.domain.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public Todo insert(Todo todo) {
		return todoRepository.save(todo);
	}

	public Todo findById(Long id) {
		return todoRepository.findById(id).orElseThrow(() -> new TodoNaoEncontradoException(id));
	}

	public void deleteById(Long id) {
		try {
			todoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new TodoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException ex) {
			throw new TodoEmUsoException(id);
		}
	}

	public Todo activeStatus(Long id) {
		return todoRepository.findById(id).map(todo -> {
			todo.setStatus(Boolean.TRUE);
			todo.setDataFinalizacao(LocalDateTime.now());
			todoRepository.save(todo);
			return todo;
		}).orElseThrow(() -> new TodoNaoEncontradoException(id));
	}

}
