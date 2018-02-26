package com.youtube.demo.service;

import java.util.List;

import com.youtube.demo.model.User;

public interface UserService {

	/**
	 * Guarda un usuario en la aplicacion
	 * @param user
	 * @return el usuario guardado
	 */
	User save(User user);

	/**
	 * Recupera lista de usuarios
	 * @return lista de usuarios
	 */
	List<User> findAll();

}
