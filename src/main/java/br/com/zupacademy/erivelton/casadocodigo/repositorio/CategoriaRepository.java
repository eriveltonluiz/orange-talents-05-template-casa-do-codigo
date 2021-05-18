package br.com.zupacademy.erivelton.casadocodigo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

}
