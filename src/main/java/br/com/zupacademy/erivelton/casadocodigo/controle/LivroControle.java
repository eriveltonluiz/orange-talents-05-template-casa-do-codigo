package br.com.zupacademy.erivelton.casadocodigo.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.LivroDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.dto.resposta.DetalhesLivroResposta;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalhesLivroResposta> buscarPorId(@PathVariable Long id){
		
		Livro livro = em.find(Livro.class, id);
		
		if(livro == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalhesLivroResposta livroResposta = new DetalhesLivroResposta(livro);
		
		return ResponseEntity.ok(livroResposta);
	}
	
	@PostMapping()
	@Transactional
	public String salvar(@Valid @RequestBody LivroDTORequisicao livroRequest) {
		Livro livro = livroRequest.toModel(em);
		em.persist(livro);
		return livro.toString();
	}
}
