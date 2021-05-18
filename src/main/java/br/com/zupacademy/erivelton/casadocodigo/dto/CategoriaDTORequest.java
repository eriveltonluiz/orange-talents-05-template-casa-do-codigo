package br.com.zupacademy.erivelton.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDTORequest {
	
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}
}
