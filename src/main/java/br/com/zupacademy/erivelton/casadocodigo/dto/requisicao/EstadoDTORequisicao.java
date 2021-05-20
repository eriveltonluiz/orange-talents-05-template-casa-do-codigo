package br.com.zupacademy.erivelton.casadocodigo.dto.requisicao;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Estado;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Pais;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.ExisteId;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.UniqueValue;

public class EstadoDTORequisicao {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@ExisteId(classe = Pais.class)
	private Long paisId;

	public EstadoDTORequisicao(@NotBlank String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado paraEntidade(EntityManager em) {
		Pais pais = em.find(Pais.class, paisId);
		return new Estado(this.nome, pais);
	}

}
