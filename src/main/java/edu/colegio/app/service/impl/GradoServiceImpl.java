package edu.colegio.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.colegio.app.entities.Grado;
import edu.colegio.app.repository.IGradoRepository;
import edu.colegio.app.service.IGradoService;

@Service
@Transactional(readOnly = true)
public class GradoServiceImpl implements IGradoService{

	@Autowired
	private IGradoRepository gradoRepository;
	
	@Transactional
	@Override
	public Grado save(Grado t) throws Exception {
		
		return gradoRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		gradoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Grado> findById(Integer id) throws Exception {
		
		return gradoRepository.findById(id);
	}

	@Override
	public List<Grado> findAll() throws Exception {
		
		return gradoRepository.findAll();
	}

}
