package edu.colegio.app.service;

import java.util.Date;
import java.util.List;

import edu.colegio.app.entities.Matricula;

public interface IMatriculaService extends ICrudService<Matricula>{

	List<Matricula> findMatriculasEntreFechas(Date fechaInicio, Date fechaFin) throws Exception;
}
