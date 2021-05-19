package br.com.zupacademy.erivelton.casadocodigo.config.excecao;

public class CategoriaNaoEncontradaExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CategoriaNaoEncontradaExcecao() {
		super("ID da categoria não foi encontrada!!");
	}
}
