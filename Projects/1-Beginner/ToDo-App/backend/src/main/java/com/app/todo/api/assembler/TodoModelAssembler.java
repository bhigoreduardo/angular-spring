package com.app.todo.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.todo.api.model.TodoModel;
import com.app.todo.domain.model.Todo;

@Component
public class TodoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TodoModel toModel(Todo todo) {
		return modelMapper.map(todo, TodoModel.class);
	}
	
	public List<TodoModel> toCollectionModel(List<Todo> todos) {
		return todos.stream()
				.map(todo -> toModel(todo))
				.collect(Collectors.toList());
	}

}
