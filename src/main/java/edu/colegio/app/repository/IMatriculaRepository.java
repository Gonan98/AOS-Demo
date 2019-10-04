package edu.colegio.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.colegio.app.entities.Matricula;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Integer>{

	@Query("Select m from Matricula m where m.fechaMatricula between fechaInicio and fechaFin")
	public List<Matricula> findMatriculasEntreFechas(@Param("fechaInicio")Date FechaInicio, @Param("fechaFin")Date FechaFin);
}
