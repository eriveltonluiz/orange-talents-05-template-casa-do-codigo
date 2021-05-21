package br.com.zupacademy.erivelton.casadocodigo.dto.requisicao;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Cliente;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Estado;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Pais;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.CPFOrCNPJ;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.ExisteId;
import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.UniqueValue;

public class ClienteDTORequisicao {
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@Email
	@NotBlank
	private String email; 

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@CPFOrCNPJ
	@NotBlank
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento; 
	
	@NotBlank
	private String cidade; 
	
	@NotNull
	@ExisteId(classe = Pais.class)
	private Long paisId;
	
	private Long estadoId;
	
	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteDTORequisicao(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long paisId, Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getEstadoId() {
		return estadoId;
	}
	
	public Long getPaisId() {
		return paisId;
	}
	
	public Cliente paraEntidade(EntityManager em) {
		Pais pais = em.find(Pais.class, paisId);
		Estado estado = null;
		if(estadoId != null) {
			estado = em.find(Estado.class, estadoId);
		}
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
	}
	
}
