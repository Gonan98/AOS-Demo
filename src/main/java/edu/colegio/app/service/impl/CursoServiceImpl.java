package edu.colegio.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.colegio.app.entities.Curso;
import edu.colegio.app.entities.Grado;
import edu.colegio.app.repository.ICursoRepository;
import edu.colegio.app.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private ICursoRepository cursoRepository;
	
	@Transactional
	@Override
	public Curso save(Curso t) throws Exception {
		return cursoRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		cursoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Curso> findById(Integer id) throws Exception {
		
		return cursoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Curso> findAll() throws Exception {
		
		return cursoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Curso> findByGrado(Grado grado) throws Exception {
		
		return cursoRepository.findByGrado(grado);
	}

}
