package br.com.zupacademy.erivelton.casadocodigo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.erivelton.casadocodigo.entidade.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Long>{
	
	boolean existsByPaisId(Long pais);
	
	boolean existsByPais_IdAndId(Long pais, Long estado);
}
