package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.LivroDTORequest;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Livro;

@RestController
public class LivroControle {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value = "/livros")
	@Transactional
	public String salvar(@Valid @RequestBody LivroDTORequest livroRequest) {
		Livro livro = livroRequest.toModel(em);
		em.persist(livro);
		return livro.toString();
	}
}
