package br.com.zupacademy.erivelton.casadocodigo.dto.requisicao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Autor;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.UniqueValue;


public class AutorDTORequisicao {
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDTORequisicao(@NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
