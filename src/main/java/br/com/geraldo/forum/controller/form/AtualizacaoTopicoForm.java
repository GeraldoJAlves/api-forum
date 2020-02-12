package br.com.geraldo.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.geraldo.forum.model.Topico;

public class AtualizacaoTopicoForm {

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String mensagem;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String titulo;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Topico atualizar(Long id, Topico topico) {
		
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		return topico;
	}

}
