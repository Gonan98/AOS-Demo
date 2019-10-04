package edu.colegio.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "curso_id")
	private Integer id;
	
	@Size(min=3, message = "Los nombres deben tener minimo 3 caracteres")
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@Size(min=3, message = "La descripcion debe tener minimo 3 caracteres")
	@Column(name = "descripcion", length = 120, nullable = true)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "grado_id")
	private Grado grado;
	
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

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

}
