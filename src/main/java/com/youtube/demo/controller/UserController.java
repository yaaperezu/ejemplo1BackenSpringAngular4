package com.youtube.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.PermisoEntity;
import com.youtube.demo.model.User;
import com.youtube.demo.service.PermisoService;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected PermisoService permisoService;

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
	
	@RequestMapping(value = "/getPermisos", method = RequestMethod.GET)
	public List<PermisoEntity> getPermisos() {
		List<PermisoEntity> listPermisos = this.permisoService.findAll();
		StringBuffer sbCodigo = new StringBuffer();
		System.out.println("/******************************************/");
		sbCodigo.append("Permission[] arrayPermissions = new Permission["+listPermisos.size()+"];");
		sbCodigo.append("\n");
		sbCodigo.append("Permission per = null;");
		sbCodigo.append("\n");
		System.out.println(sbCodigo.toString());
		int i = 0;
		for(PermisoEntity permItem: listPermisos) {
			sbCodigo = new StringBuffer();
			sbCodigo.append("per = new Permission();");
			sbCodigo.append("\n");
			sbCodigo.append("per.setId("+i+");");
			sbCodigo.append("\n");
			sbCodigo.append("per.setName(\""+permItem.getNombre()+"\");");
			sbCodigo.append("\n");
			sbCodigo.append("per.setDescription(\""+permItem.getNombre()+"\");");
			sbCodigo.append("\n");
			sbCodigo.append("arrayPermissions["+i+"] = per;");
			sbCodigo.append("\n");
			System.out.println(sbCodigo.toString());
			
			i++;
		}
		System.out.println("/******************************************/");
		return listPermisos;
	}
	
	@RequestMapping(value = "/listPermisos", method = RequestMethod.GET)
	public List<PermisoEntity> listPermisos(Pageable pageable) {
		return this.permisoService.listarPorPaginas(pageable);
	}
}
