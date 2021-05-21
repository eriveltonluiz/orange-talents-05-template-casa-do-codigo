package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.ClienteDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Cliente;
import br.com.zupacademy.erivelton.casadocodigo.validacao.validador.ProibeIncorrecoesEstadoCidade;

@RestController
public class ClienteControle {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProibeIncorrecoesEstadoCidade proibeIncorrecoesEstadoCidade;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeIncorrecoesEstadoCidade);
	}

	@PostMapping(value = "/clientes")
	@Transactional
	public String salvar(@RequestBody @Valid ClienteDTORequisicao clienteRequest) {
		Cliente cliente = clienteRequest.paraEntidade(em);
		em.persist(cliente);
		return cliente.toString();
	}

}