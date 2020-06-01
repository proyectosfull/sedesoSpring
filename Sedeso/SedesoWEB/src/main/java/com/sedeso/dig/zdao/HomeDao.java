package com.sedeso.dig.zdao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;

@Component
public class HomeDao  implements IHomeDao{
	private final Logger logger = LoggerFactory.getLogger(HomeDao.class);

	@Override
	public void homeDao() {
		// TODO Auto-generated method stub
				 logger.info("Dao Home");
	}

	
}
