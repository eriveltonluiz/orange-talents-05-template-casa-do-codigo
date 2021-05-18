package br.com.zupacademy.erivelton.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Categoria;
import br.com.zupacademy.erivelton.casadocodigo.validacaounicidade.UniqueValue;

public class CategoriaDTORequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}
}
