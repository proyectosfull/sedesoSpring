package com.sedeso.dig.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sedeso.dig.zdao.IReportesDao;

@Service
public class HomeService implements IHomeService {
	private final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	@Autowired
	private IReportesDao iReportesDao;

	@Override
	public void home() {
		// TODO Auto-generated method stub
		 logger.info("Service Home");
	}
	
	@Override
	public List<String> consultaReporte(String user) throws Exception{
		return iReportesDao.consultaDirReporte(user);
	}
	
}
