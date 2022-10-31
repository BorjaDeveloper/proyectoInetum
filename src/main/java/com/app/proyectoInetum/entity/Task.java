package com.app.proyectoInetum.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column
	private String nombre;

	@Column
	private String descripcion;

	@Column
	private String plazo;

	public Task() {

	}

	public Task(Integer id, String nombre, String descripcion, String plazo) {
		super();
		Id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.plazo = plazo;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	@Override
	public String toString() {
		return "Task [Id=" + Id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", plazo=" + plazo + "]";
	}

}