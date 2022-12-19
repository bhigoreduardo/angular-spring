package com.app.todo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.api.assembler.TodoModelAssembler;
import com.app.todo.api.assembler.TodoModelDiassembler;
import com.app.todo.api.model.TodoModel;
import com.app.todo.api.model.input.TodoInput;
import com.app.todo.domain.model.Todo;
import com.app.todo.domain.repository.TodoRepository;
import com.app.todo.domain.service.TodoService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://127.0.0.1:4200")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoModelDiassembler todoModelDiassembler;

	@Autowired
	private TodoModelAssembler todoModelAssembler;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public TodoModel insert(@RequestBody TodoInput todoInput) {
		Todo todo = todoModelDiassembler.toDomain(todoInput);

		return todoModelAssembler.toModel(todoService.insert(todo));
	}

	@GetMapping("/{id}")
	public TodoModel findById(@PathVariable Long id) {
		return todoModelAssembler.toModel(todoService.findById(id));
	}

	@GetMapping("/{texto}/comeco")
	public List<TodoModel> findByDescricaoStartingWith(@PathVariable String texto) {
		return todoModelAssembler.toCollectionModel(todoRepository.findByDescricaoStartingWith(texto));
	}
	
	@GetMapping
	public List<TodoModel> findAll() {
		return todoModelAssembler.toCollectionModel(todoRepository.findAll());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		todoService.deleteById(id);
	}
	
	@PatchMapping("/{id}/feito")
	public TodoModel activeStatus(@PathVariable Long id) {
		return todoModelAssembler.toModel(todoService.activeStatus(id));
	}

}
