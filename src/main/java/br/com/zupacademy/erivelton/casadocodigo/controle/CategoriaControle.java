package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.CategoriaDTORequest;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Categoria;
import br.com.zupacademy.erivelton.casadocodigo.repositorio.CategoriaRepository;

@RestController
public class CategoriaControle {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping(value = "/categorias")
	@Transactional
	public String salvar(@Valid @RequestBody CategoriaDTORequest categoriaDTORequest) {
		Categoria categoria = new Categoria(categoriaDTORequest.getNome());
		categoriaRepository.save(categoria);
		return categoria.toString();
	}
}
