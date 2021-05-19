package br.com.zupacademy.erivelton.casadocodigo.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@Lob
	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotNull
	@Min(value = 100)
	private Long pagina;
	
	@Lob
	private String sumario;
	
	@NotNull
	@DecimalMin(value = "20")
	private BigDecimal preco;
	
	@NotBlank
	@ISBN(type = Type.ISBN_13)
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull @Min(100) Long pagina,
			String sumario, @NotNull @DecimalMin("20") BigDecimal preco, @NotBlank @ISBN(type = Type.ISBN_13) String isbn,
			@Future LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.pagina = pagina;
		this.sumario = sumario;
		this.preco = preco;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + "]";
	}
	
}
