package br.com.geraldo.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.geraldo.forum.model.Resposta;

public class RespostaDto {

	private Long id;
	private String mensagem;
	private String nomeAutor;

	public RespostaDto(Resposta resposta) {
		id = resposta.getId();
		mensagem = resposta.getMensagem();
		nomeAutor = resposta.getNomeAutor();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public static List<RespostaDto> converter(List<Resposta> respostas) {
		return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
	}

}
