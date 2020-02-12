package br.com.geraldo.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geraldo.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	public Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
	
}
