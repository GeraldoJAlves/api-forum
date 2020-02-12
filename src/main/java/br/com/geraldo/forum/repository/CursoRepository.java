package br.com.geraldo.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geraldo.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	public Curso findByNome(String nome);

}
