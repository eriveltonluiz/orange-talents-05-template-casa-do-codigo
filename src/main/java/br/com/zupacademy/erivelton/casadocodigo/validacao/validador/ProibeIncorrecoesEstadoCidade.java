package br.com.zupacademy.erivelton.casadocodigo.validacao.validador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.erivelton.casadocodigo.dto.requisicao.ClienteDTORequisicao;
import br.com.zupacademy.erivelton.casadocodigo.repositorio.EstadoRepositorio;

@Component
public class ProibeIncorrecoesEstadoCidade implements Validator {

	@Autowired
	private EstadoRepositorio repositorio;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDTORequisicao.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteDTORequisicao cliente = (ClienteDTORequisicao) target;

		boolean estadosExistentesNoPais = repositorio.existsByPaisId(cliente.getPaisId());
		boolean estadoExistenteNoPais = repositorio.existsByPais_IdAndId(cliente.getPaisId(), cliente.getEstadoId());

		if (cliente.getEstadoId() == null && estadosExistentesNoPais) 
			errors.rejectValue("EstadoId", null, "Necessário inserir um estado!!");
		else if (cliente.getEstadoId() != null && !estadoExistenteNoPais) 
			errors.rejectValue("EstadoId", null, "Estado não existe no país!!");
			
	}
	
}