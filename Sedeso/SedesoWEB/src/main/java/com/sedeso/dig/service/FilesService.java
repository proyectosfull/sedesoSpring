package com.sedeso.dig.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sedeso.dig.zdao.HomeDao;

@Service
public class FilesService implements IFilesService{
	private final Logger logger = LoggerFactory.getLogger(FilesService.class);

	@Override
	public boolean insertFiles(MultipartFile fileUno, MultipartFile fileDos, MultipartFile fileTres,
			MultipartFile fileCuatro, MultipartFile fileCinco, String nombBenef, String telContact, String email,
			String beneficiariosDom, String observVisit, String usuario) {
		// TODO Auto-generated method stub
		boolean bGuardo = true;
		return bGuardo;
	}

	
	


}
