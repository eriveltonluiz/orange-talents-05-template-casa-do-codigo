package br.com.zupacademy.erivelton.casadocodigo.config.validacao;

import java.time.LocalDateTime;

public class ErroFormulario {
	
	private String campo;
	private String mensagem;
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
