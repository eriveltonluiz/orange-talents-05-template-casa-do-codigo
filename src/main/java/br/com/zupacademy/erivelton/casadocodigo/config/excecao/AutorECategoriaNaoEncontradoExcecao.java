package br.com.zupacademy.erivelton.casadocodigo.config.excecao;

public class AutorECategoriaNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutorECategoriaNaoEncontradoExcecao() {
		super("ID de autor e categoria não foram encontrados!!");
	}
}
