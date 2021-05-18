package br.com.zupacademy.erivelton.casadocodigo.config.validacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErroValidacao extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErroFormulario> erroFormularios = new ArrayList<>();
		List<FieldError> erros = ex.getBindingResult().getFieldErrors();
		
		erros.forEach(fieldError -> {
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			ErroFormulario erro = new ErroFormulario(fieldError.getField(), fieldError.getField() + " " + mensagem, LocalDateTime.now());
			erroFormularios.add(erro);
		});
		
		return handleExceptionInternal(ex, erroFormularios, headers, status, request);
	}
}
