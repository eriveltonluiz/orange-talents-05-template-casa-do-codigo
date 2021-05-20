package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.PaisDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Pais;

@RestController
public class PaisControle {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value = "/paises")
	@Transactional
	public String salvar(@Valid @RequestBody PaisDTORequisicao paisRequisicao) {
		Pais pais = new Pais(paisRequisicao.getNome());
		em.persist(pais);
		return pais.toString();
	}
}
