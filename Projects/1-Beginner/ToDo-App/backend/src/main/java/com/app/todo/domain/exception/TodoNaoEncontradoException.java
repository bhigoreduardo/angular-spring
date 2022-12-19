package com.app.todo.domain.exception;

public class TodoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 5619971024306663851L;

	public TodoNaoEncontradoException(Long id) {
		super(String.format("Tarefa cód. %d não foi encontrada.", id));
	}

}
