package br.com.zupacademy.erivelton.casadocodigo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;

	public Categoria(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + "]";
	}
	
}
