package com.pedro.buscacep.exceptions;

public class CepException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensagem;

	public CepException(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.mensagem;
	}
}
