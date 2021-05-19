package br.com.zupacademy.erivelton.casadocodigo.dto.resposta;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Autor;

public class DetalhesAutorResposta {

	private String autor;
	
	private String descricao;
	
	public DetalhesAutorResposta(Autor autor) {
		this.autor = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getAutor() {
		return autor;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
