package com.sedeso.dig.zdao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;

public class UsuarioDao {
	private final Logger logger = LoggerFactory.getLogger(UsuarioDao.class);
	
	public String usuario;
	
	public UsuarioDao(String usuario) {
		super();
		this.usuario = usuario;
	}
	
	public UsuarioDao() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
