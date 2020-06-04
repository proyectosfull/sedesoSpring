package com.sedeso.dig.zdao;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;

import java.util.*; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;


@Component("reportesDao")
public class ReportesDao implements IReportesDao {
	private final Logger logger = LoggerFactory.getLogger(IReportesDao.class);
	
	
	@Override
	public List<String> consultaDirReporte(String user) throws Exception {
		// TODO Auto-generated method stub
		list.clear();
		
		File directorio = new File("C:\\Reportes\\" + user);
		if (directorio.exists()) {
			listf(directorio.toString());
			return list;
		} else {
			list.add("Sin archivos");
			return list;
		}
		
	}

	public  void listf(String directoryName) {
		File directory = new File(directoryName);

		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				list.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				listf(file.getAbsolutePath());
			}
		}
		logger.info("Directorio: " + fList[0].toString());
	
	}
	public static <T> List<T> convertArrayToList(T File[]) 
    { 
        List<T> list = new ArrayList<>(); 
        for (T t : File) { 
            list.add(t); 
        }  
        return list; 
    } 

}
