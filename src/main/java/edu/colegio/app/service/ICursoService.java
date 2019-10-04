package edu.colegio.app.service;

import java.util.List;

import edu.colegio.app.entities.Curso;
import edu.colegio.app.entities.Grado;

public interface ICursoService extends ICrudService<Curso>{
	List<Curso> findByGrado(Grado grado) throws Exception;
}
