package com.sedeso.dig.zdao;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*; 
import java.util.stream.*; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;

@Component("reportesDao")
public class ReportesDao implements IReportesDao {
	private final Logger logger = LoggerFactory.getLogger(IReportesDao.class);
	List<String> lista = new ArrayList<String>();
	
	@Override
	public List<String> consultaDirReporte(String user) throws Exception {
		// TODO Auto-generated method stub
		List<String> a = new ArrayList<String>();
		File[]b;
		File directorio = new File("C:\\Reportes\\" + user);
		if (directorio.exists()) {
			listf(directorio.toString());
			return a;
		} else {
			a.add("Sin archivos");
			return a;
		}
		
	}

	public  void listf(String directoryName) {
		File directory = new File(directoryName);

		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				lista.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				lista.add(file.getAbsolutePath());
			}
		}
		logger.info("Directorio: " + fList.toString());
	
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
