package com.youtube.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User extends ParentEntity {

	private static final long serialVersionUID = 8435405591663518471L;

	@Column(name = "user_name", nullable = false, length = 50)
	private String userName;
	
	@Column(name = "user_password", nullable = false, length = 50)
	private String userPassword;

	@Column(name = "firs_name", nullable = false, length = 255)
	private String firsName;

	@Column(name = "second_name", nullable = true, length = 255)
	private String secondName;

	@Column(name = "firs_surname", nullable = false, length = 255)
	private String firsSurname;

	@Column(name = "second_surname", nullable = true, length = 255)
	private String secondSurname;

	@Column(name = "phone", nullable = true, length = 10)
	private String phone;

	@Column(name = "addres", nullable = true, length = 150)
	private String addres;
	
	@Column(name = "rol")
	private int rol;
	
	@Column(name = "estado")
	private String estado;

	public User() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirsName() {
		return firsName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getFirsSurname() {
		return firsSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddres() {
		return addres;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setFirsSurname(String firsSurname) {
		this.firsSurname = firsSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getRol() {
		return rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
