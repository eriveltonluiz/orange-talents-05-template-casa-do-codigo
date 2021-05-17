package br.com.zupacademy.erivelton.casadocodigo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Autor;

@Repository
public interface AutorRepositorio extends CrudRepository<Autor, Long>{

}
