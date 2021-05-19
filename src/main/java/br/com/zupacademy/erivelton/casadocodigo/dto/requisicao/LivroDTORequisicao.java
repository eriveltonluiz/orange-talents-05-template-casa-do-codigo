package br.com.zupacademy.erivelton.casadocodigo.dto.requisicao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.erivelton.casadocodigo.config.excecao.AutorECategoriaNaoEncontradoExcecao;
import br.com.zupacademy.erivelton.casadocodigo.config.excecao.AutorNaoEncontradoExcecao;
import br.com.zupacademy.erivelton.casadocodigo.config.excecao.CategoriaNaoEncontradaExcecao;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Autor;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Categoria;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Livro;
import br.com.zupacademy.erivelton.casadocodigo.validacaounicidade.UniqueValue;

public class LivroDTORequisicao {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotNull
	@Min(value = 100)
	private Long pagina;

	private String sumario;

	@NotNull
	@DecimalMin(value = "20")
	private BigDecimal preco;

	@NotBlank
	@ISBN(type = Type.ISBN_13)
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@Future
	@JsonFormat(timezone = "GMT-3", pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	private Long categoriaId;

	@NotNull
	private Long autorId;

	public LivroDTORequisicao(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotNull @Min(100) Long pagina, String sumario, @NotNull @DecimalMin("20") BigDecimal preco,
			@NotBlank @ISBN(type = Type.ISBN_13) String isbn, @Future LocalDate dataPublicacao, @NotNull Long categoriaId,
			@NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.pagina = pagina;
		this.sumario = sumario;
		this.preco = preco;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro toModel(EntityManager em) {
		Categoria categoria = em.find(Categoria.class, categoriaId);
		Autor autor = em.find(Autor.class, autorId);

		if (categoria == null && autor != null) {
			throw new CategoriaNaoEncontradaExcecao();
		} else if (autor == null && categoria != null) {
			throw new AutorNaoEncontradoExcecao();
		} else if (autor == null && categoria == null) {
			throw new AutorECategoriaNaoEncontradoExcecao();
		}
		
		return new Livro(titulo, resumo, pagina, sumario, preco, isbn, dataPublicacao, categoria, autor);
	}

}
