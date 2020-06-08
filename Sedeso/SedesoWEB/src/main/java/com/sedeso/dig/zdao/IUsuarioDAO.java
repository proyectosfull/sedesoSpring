package com.sedeso.dig.zdao;

import java.sql.SQLException;

public interface IUsuarioDAO {

	public int consultaUsuario(String usr) throws SQLException;
	
}
