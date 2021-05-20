package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.EstadoDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Estado;

@RestController
public class EstadoControle {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value = "/estados")
	@Transactional
	public String salvar(@Valid @RequestBody EstadoDTORequisicao estadoRequisicao) {
		Estado estado = estadoRequisicao.paraEntidade(em);
		em.persist(estado);
		return estado.toString();
	}
}
