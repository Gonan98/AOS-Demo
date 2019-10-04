package edu.colegio.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.colegio.app.entities.Curso;
import edu.colegio.app.entities.Grado;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer>{

	public List<Curso> findByGrado(Grado grado);
}
