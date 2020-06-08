package com.sedeso.dig.service;

import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

public interface IFilesService {
	
	public boolean insertFiles(MultipartFile fileUno,
							   MultipartFile fileDos,
							   MultipartFile fileTres,
							   MultipartFile fileVideo,
							   MultipartFile fileAudio, 
							   String nombBenef,
							   String telContact,
							   String email,
							   String beneficiariosDom,
							   String observVisit,
							   String usuario								
							   );
	
}
