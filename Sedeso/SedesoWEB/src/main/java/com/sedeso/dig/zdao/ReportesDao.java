package com.sedeso.dig.zdao;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*; 
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
		
		File[]b;
		File directorio = new File("C:\\Reportes\\" + user);
		if (directorio.exists()) {
			listf(directorio.toString());
			return lista;
		} else {
			lista.add("Sin archivos");
			return lista;
		}
		
	}

	public  void listf(String directoryName) {
		File directory = new File(directoryName);

		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				lista.add(file.getAbsolutePath());
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
