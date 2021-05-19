package br.com.zupacademy.erivelton.casadocodigo.controle;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.erivelton.casadocodigo.dto.AutorDTORequest;
import br.com.zupacademy.erivelton.casadocodigo.entidade.Autor;
import br.com.zupacademy.erivelton.casadocodigo.repositorio.AutorRepositorio;

@RestController
public class AutorControle {

	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@PostMapping(value = "/autores")
	@Transactional
	public ResponseEntity<AutorDTORequest> salvar(@RequestBody @Valid AutorDTORequest autorRequest){
		Autor autor = new Autor(autorRequest.getNome(), autorRequest.getEmail(), autorRequest.getDescricao());
		autorRepositorio.save(autor);
		return ResponseEntity.ok(autorRequest);
	}
	
}