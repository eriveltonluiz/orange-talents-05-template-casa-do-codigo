package br.com.zupacademy.erivelton.casadocodigo.config.excecao;

public class AutorNaoEncontradoExcecao extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AutorNaoEncontradoExcecao() {
		super("ID do autor não foi encontrado!!");
	}
}
