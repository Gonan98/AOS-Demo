package edu.colegio.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.colegio.app.entities.Matricula;
import edu.colegio.app.repository.IMatriculaRepository;
import edu.colegio.app.service.IMatriculaService;

@Service
@Transactional(readOnly = true)
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Transactional
	@Override
	public Matricula save(Matricula t) throws Exception {
		
		return matriculaRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		
		matriculaRepository.deleteById(id);
	}

	@Override
	public Optional<Matricula> findById(Integer id) throws Exception {
		
		return matriculaRepository.findById(id);
	}

	@Override
	public List<Matricula> findAll() throws Exception {
		
		return matriculaRepository.findAll();
	}

	@Override
	public List<Matricula> findMatriculasEntreFechas(Date fechaInicio, Date fechaFin) throws Exception {
		
		return matriculaRepository.findMatriculasEntreFechas(fechaInicio, fechaFin);
	}

}
