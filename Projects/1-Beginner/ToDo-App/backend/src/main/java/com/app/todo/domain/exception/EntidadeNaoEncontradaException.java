package com.app.todo.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 3190177472409831604L;
	
	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

}
