package com.youtube.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
@Access(AccessType.FIELD)
public class PermisoEntity extends ParentEntity {

	private static final long serialVersionUID = -9024055328704570028L;

	@Column(name = "nombre", nullable = true, length = 255)
	private String nombre;

	public PermisoEntity() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
