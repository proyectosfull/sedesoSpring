package com.sedeso.dig.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sedeso.dig.controllers.restclient.RestClient;
import com.sedeso.dig.util.MultipartUtility;

@Service
public class FilesService implements IFilesService{
	private final Logger logger = LoggerFactory.getLogger(RestClient.class);
	
	
	@Override
	public boolean insertFiles(MultipartFile fileUno, MultipartFile fileDos, MultipartFile fileTres,
			MultipartFile fileVideo, MultipartFile fileAudio, String nombBenef, String telContact, String email, String prioridad,
			String beneficiariosDom, String observVisit, String usuario,String lat, String lng, String nombre, String metros, String domicilio) {
		
		// TODO Auto-generated method stub
	      String charset="UTF-8";
	      String url ="http://23.82.16.144:8080/SEDESO/Reporte?action=insertar";
	      
	      lat = (lat.equals("") || lat == null )? "0" : lat;
	      lng = (lng.equals("") || lng == null )? "0" : lng;
	      
		boolean bGuardo = true;
		try {
			MultipartUtility multipart = new MultipartUtility(url, charset);
			
			File foto1 = (fileUno.getSize() > 0)? convert(fileUno) : null;
			File foto2 = (fileDos.getSize() > 0)? convert(fileDos) : null;
			File foto3 = (fileTres.getSize() > 0)? convert(fileTres) : null;
			
			File video =(fileVideo.getSize() > 0)? convert(fileVideo) : null;
			File audio =(fileAudio.getSize() > 0)? convert(fileAudio) : null;
			

			
			if (foto1 !=null && foto2 !=null && foto3 !=null) {
				multipart.addFilePart("picture_file_1",foto1);
				multipart.addFilePart("picture_file_2",foto2);
				multipart.addFilePart("picture_file_3",foto3);
				
			}else {
				return false;
			}
			if (video != null) {
				multipart.addFilePart("video_file", video);
			}
			if(audio != null) {
				multipart.addFilePart("voice_file", audio);
			}
			
			multipart.addFormField("params","1~~"+nombBenef);
			multipart.addFormField("params","2~~"+telContact);
			multipart.addFormField("params","3~~"+email);
			multipart.addFormField("params","4~~"+prioridad);
			multipart.addFormField("params","5~~"+beneficiariosDom);
			multipart.addFormField("params","6~~"+observVisit);
			
			
			multipart.addFormField("personalId", usuario);
			multipart.addFormField("reportId", "1");
			multipart.addFormField("lat", lat);
			multipart.addFormField("lng", lng);
			multipart.addFormField("nombre", nombre);
			multipart.addFormField("metros", metros);
			multipart.addFormField("domicilio", domicilio);
			
			
			List<String> response = multipart.finish();
			StringBuilder builder = new StringBuilder();
			for(String line: response)
				builder.append(line);
			logger.info("Builder:"+builder.toString());
			JSONObject jsonResponse = new JSONObject(builder.toString());
			if (jsonResponse.getBoolean("OK")) {
				bGuardo =true;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return bGuardo;
	}
	
	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	
}
