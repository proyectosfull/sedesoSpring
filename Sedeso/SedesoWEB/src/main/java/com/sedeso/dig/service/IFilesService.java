package com.sedeso.dig.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFilesService {
	
	public boolean insertFiles(MultipartFile fileUno,
							   MultipartFile fileDos,
							   MultipartFile fileTres,
							   MultipartFile fileCuatro,
							   MultipartFile fileCinco, 
							   String nombBenef,
							   String telContact,
							   String email,
							   String beneficiariosDom,
							   String observVisit,
							   String usuario								
							   );
}
