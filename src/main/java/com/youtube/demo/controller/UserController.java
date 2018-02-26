package com.youtube.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdateUser", method = RequestMethod.POST)
	public RestResponse saveOrUpdateUser(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);

		if (!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios no se han diligenciado");
		}
		this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);

		if (StringUtils.isEmpty(user.getId())) {
			throw new Exception("El id del usuario llega nulo");
		}
		
		this.userService.deleteUser(user.getId());
	}

	private boolean validate(User user) {
		boolean isValid = true;

		if (StringUtils.isEmpty(user.getFirsName())) {
			isValid = false;
		}

		if (StringUtils.isEmpty(user.getFirsSurname())) {
			isValid = false;
		}

		return isValid;
	}
}
