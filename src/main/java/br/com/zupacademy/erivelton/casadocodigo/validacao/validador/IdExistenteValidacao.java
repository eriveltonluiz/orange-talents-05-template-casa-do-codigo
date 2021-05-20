package br.com.zupacademy.erivelton.casadocodigo.validacao.validador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao.ExisteId;

public class IdExistenteValidacao implements ConstraintValidator<ExisteId, Object> {

	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(ExisteId constraintAnnotation) {
		classe = constraintAnnotation.classe();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = em.createQuery("select 1 from " + classe.getName() + " where id = :valor");
		query.setParameter("valor", value);
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}

}
