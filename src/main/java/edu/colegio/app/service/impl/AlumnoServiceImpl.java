package edu.colegio.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.colegio.app.entities.Alumno;
import edu.colegio.app.repository.IAlumnoRepository;
import edu.colegio.app.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoRepository alumnoRepository;

	@Transactional
	@Override
	public Alumno save(Alumno t) throws Exception {
		return alumnoRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alumnoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Alumno> findById(Integer id) throws Exception {
		return alumnoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Alumno> findAll() throws Exception {
		return alumnoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Alumno> findByApellidos(String apellidos) throws Exception {
		return alumnoRepository.findByApellidos(apellidos);
	}

	@Transactional(readOnly = true)
	@Override
	public Alumno findByDni(String dni) throws Exception {
		return alumnoRepository.findByDni(dni);
	}

}
