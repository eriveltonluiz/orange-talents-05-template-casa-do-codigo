package br.com.zupacademy.erivelton.casadocodigo.entidade;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.UniqueValue;

@SuppressWarnings("unused")
@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Column(unique = true)
	@Email
	@NotBlank
	private String email;
	
	@Lob
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	private LocalDateTime instanteRegistro = LocalDateTime.now();

	@Deprecated
	public Autor() {
		
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
