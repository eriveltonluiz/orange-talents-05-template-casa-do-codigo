package br.com.zupacademy.erivelton.casadocodigo.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.LivroDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.dto.resposta.LivroDTOResposta;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Livro;

@RestController
@RequestMapping(value = "/livros")
public class LivroControle {

	@PersistenceContext
	private EntityManager em;
	
	@GetMapping
	public List<LivroDTOResposta> itensLivros(){
		@SuppressWarnings("unchecked")
		List<LivroDTOResposta> livrosDTO = em.createQuery("select new br.com.zupacademy.erivelton.casadocodigo.dto.resposta.LivroDTOResposta(l.id, l.titulo) from Livro l").getResultList();
		return livrosDTO;
	}
	
	@PostMapping()
	@Transactional
	public String salvar(@Valid @RequestBody LivroDTORequisicao livroRequest) {
		Livro livro = livroRequest.toModel(em);
		em.persist(livro);
		return livro.toString();
	}
}
