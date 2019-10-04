package edu.colegio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.colegio.app.entities.Grado;

@Repository
public interface IGradoRepository extends JpaRepository<Grado, Integer>{

}
