package com.app.proyectoInetum.entity;
	

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "employees")
	public class Employee  {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer Id;
		
		@Column
		private String nombre;
		
		@Column
		private String apellido;
		
		@Column
		private String direccion;
		
		public Employee() {			
			
		}

		public Employee(Integer id, String nombre, String apellido, String direccion) {
			super();
			Id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		@Override
		public String toString() {
			return "Employee [Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
					+ "]";
		}
		
		
}
