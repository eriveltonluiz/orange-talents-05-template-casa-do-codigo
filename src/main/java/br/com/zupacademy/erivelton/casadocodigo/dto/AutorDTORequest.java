package br.com.zupacademy.erivelton.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTORequest {
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDTORequest(@NotBlank String nome, @Email @NotBlank String email,
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
