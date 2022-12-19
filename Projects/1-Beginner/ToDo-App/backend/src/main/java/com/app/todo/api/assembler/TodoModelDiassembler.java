package com.app.todo.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.todo.api.model.input.TodoInput;
import com.app.todo.domain.model.Todo;

@Component
public class TodoModelDiassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Todo toDomain(TodoInput todoInput) {
		return modelMapper.map(todoInput, Todo.class);
	}

}
