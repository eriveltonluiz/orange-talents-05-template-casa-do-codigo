package br.com.zupacademy.erivelton.casadocodigo.validacao.anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.erivelton.casadocodigo.validacao.validador.IdExistenteValidacao;

@Documented
@Constraint(validatedBy = {IdExistenteValidacao.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExisteId {
	
	String message() default "ID não encontrado";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?> classe();
}
