package br.com.zupacademy.erivelton.casadocodigo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Livro;

@Repository
public interface LivroRepositorio extends CrudRepository<Livro, Long>{

}
