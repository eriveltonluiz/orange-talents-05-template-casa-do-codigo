package br.com.zupacademy.erivelton.casadocodigo.dto.requisicao;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Pais;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.UniqueValue;

public class PaisDTORequisicao {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
}
