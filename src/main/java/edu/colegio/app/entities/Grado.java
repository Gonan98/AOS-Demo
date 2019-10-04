package edu.colegio.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "grado")
public class Grado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "grado_id")
	private Integer id;
	
	@Size(min=3, message = "Los nombres deben tener minimo 3 caracteres")
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 120, nullable = true)
	private String descripcion;
	
	@OneToMany(mappedBy = "grado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Curso> cursos;

	@OneToMany(mappedBy = "grado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Matricula> matriculas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
}
