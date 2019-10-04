package edu.colegio.app.service;

import java.util.List;

import edu.colegio.app.entities.Alumno;

public interface IAlumnoService extends ICrudService<Alumno>{
	List<Alumno> findByApellidos(String apellidos) throws Exception;
	Alumno findByDni(String dni) throws Exception; 
}
