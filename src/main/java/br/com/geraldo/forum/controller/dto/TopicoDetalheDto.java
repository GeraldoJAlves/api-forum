package br.com.geraldo.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.geraldo.forum.model.StatusTopico;
import br.com.geraldo.forum.model.Topico;

public class TopicoDetalheDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String nomeAutor;
	private String nomeCurso;
	private List<RespostaDto> respostas = new ArrayList<>();

	public TopicoDetalheDto(Topico topico) {

		id = topico.getId();
		titulo = topico.getTitulo();
		mensagem = topico.getMensagem();
		dataCriacao = topico.getDataCriacao();
		status = topico.getStatus();
		nomeAutor = topico.getNomeAutor();
		nomeCurso = topico.getNomeCurso();

		respostas.addAll(RespostaDto.converter(topico.getRespostas()));

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDto> respostas) {
		this.respostas = respostas;
	}

}
