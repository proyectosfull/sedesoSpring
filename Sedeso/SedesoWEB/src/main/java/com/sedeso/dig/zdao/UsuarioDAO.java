package com.sedeso.dig.zdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.sedeso.dig.dto.Usuario;

@Component("usuarioDAO")
public class UsuarioDAO implements IUsuarioDAO{
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	private final String SQL_CONSULTA_USUARIO = "select per.id from dbo.personal as per where per.nombre=:nombre";

	@Autowired
	@Qualifier("dataSource")
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	@Override
	public int consultaUsuario(String usr) {
		//MapSqlParameterSource in = new MapSqlParameterSource();
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("nombre", usr);
		//in.addValue("nombre", usr);
		Usuario usuario= jdbcTemplate.queryForObject(
				SQL_CONSULTA_USUARIO,
				parameters,
				new RowMapper<Usuario>() {
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum)throws SQLException{
			Usuario us = Usuario.builder()
					.id(rs.getInt("id"))
					.build();
			return us;
		}
		});
		
		return usuario.getId();
	}

//	@Override
//	public int consultaUsuario(String usr) {
//		Object[] usuario = new Object[] {usr};
//		int idusuario= jdbcTemplate.queryForObject(SQL_CONSULTA_USUARIO,usuario, String.class);
//			return idusuario;
//	}

}
