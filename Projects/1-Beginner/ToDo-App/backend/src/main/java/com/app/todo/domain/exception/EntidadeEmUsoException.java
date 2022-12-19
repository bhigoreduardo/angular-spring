package com.app.todo.domain.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 4406045859015535720L;
	
	public EntidadeEmUsoException(String message) {
		super(message);
	}

}
