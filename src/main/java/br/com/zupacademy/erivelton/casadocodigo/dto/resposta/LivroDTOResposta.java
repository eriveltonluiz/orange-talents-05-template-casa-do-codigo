package br.com.zupacademy.erivelton.casadocodigo.dto.resposta;

public class LivroDTOResposta {
	
	private Long id;
	private String nomeLivro;
	
	public LivroDTOResposta(Long id, String nomeLivro) {
		this.id = id;
		this.nomeLivro = nomeLivro;
	}

	public Long getId() {
		return id;
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	
}
