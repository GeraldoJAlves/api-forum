package br.com.geraldo.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geraldo.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	public List<Topico> findByCursoNome(String nomeCurso);
	
}
