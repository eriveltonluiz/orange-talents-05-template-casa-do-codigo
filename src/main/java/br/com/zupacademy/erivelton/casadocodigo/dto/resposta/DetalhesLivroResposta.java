package br.com.zupacademy.erivelton.casadocodigo.dto.resposta;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Livro;

public class DetalhesLivroResposta {
	
	private String titulo;

	private BigDecimal preco;

	private String resumo;

	private String sumario;

	private Long pagina;
	
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	private DetalhesAutorResposta detalhesAutorResposta;

	public DetalhesLivroResposta(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.pagina = livro.getPagina();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.detalhesAutorResposta = new DetalhesAutorResposta(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getSumario() {
		return sumario;
	}

	public DetalhesAutorResposta getDetalhesAutorResposta() {
		return detalhesAutorResposta;
	}

	public Long getPagina() {
		return pagina;
	}
	
	public String getIsbn() {
		return isbn;
	}

}
