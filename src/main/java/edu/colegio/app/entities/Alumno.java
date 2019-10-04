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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
@NamedQuery(name = "Alumno.findByDni", query = "Select a from Alumno a where a.dni = ?1")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "alumno_id")
	private Integer id;
	
	@Size(min=3, message = "Los nombres deben tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Size(min=3, message = "Los apellidos deben tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Size(min=8, message = "Los nombres deben tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Matricula> matriculas;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}
