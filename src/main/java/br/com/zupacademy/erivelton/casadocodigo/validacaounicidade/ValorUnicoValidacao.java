package br.com.zupacademy.erivelton.casadocodigo.validacaounicidade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidacao implements ConstraintValidator<UniqueValue, Object>{

	private String atributoDoDominio;
	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		atributoDoDominio = constraintAnnotation.fieldName();
		classe = constraintAnnotation.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = em.createQuery("select 1 from " + classe.getName() + " where " + atributoDoDominio + "=:valor");
		query.setParameter("valor", value);
		List<?> resultado = query.getResultList();
		return resultado.isEmpty();
	}

}
