package com.app.todo.domain.exception;

public class TodoEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1252358002014409822L;
	
	public TodoEmUsoException(Long id) {
		super(String.format("Tarefa cód. %d em uso.", id));
	}

}
