package com.sedeso.dig.zdao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;

@Component
public class HomeDao  implements IHomeDao{
	private final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public void homeDao() {
		// TODO Auto-generated method stub
				 logger.info("Dao Home");
	}

    @Autowired
    @Qualifier("dataSource")
    private void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);}

//    @Override
//    public boolean save(Admin admin) {
////        MapSqlParameterSource paramMap = new MapSqlParameterSource();
////        paramMap.addValue("nombre", admin.getNombre());
////        paramMap.addValue("cargo", admin.getCargo());
////        paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
//       
//        BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
//       
//        return jdbcTemplate.
//                update("insert into Admin (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
//    }

	
}
