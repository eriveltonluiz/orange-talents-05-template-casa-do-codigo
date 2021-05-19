package br.com.zupacademy.erivelton.casadocodigo.config.validacao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErroFormulario {
	
	private String campo;
	private String mensagem;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm.ss", timezone = "GMT-3")
	private LocalDateTime instante;
	
	public ErroFormulario() {
	}

	public ErroFormulario(String campo, String mensagem, LocalDateTime instante) {
		this.campo = campo;
		this.mensagem = mensagem;
		this.instante = instante;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public LocalDateTime getInstante() {
		return instante;
	}

}
