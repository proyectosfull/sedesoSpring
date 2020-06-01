package com.sedeso.dig.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements IHomeService {
	private final Logger logger = LoggerFactory.getLogger(HomeService.class);

	@Override
	public void home() {
		// TODO Auto-generated method stub
		 logger.info("Service Home");
	}
	
}
