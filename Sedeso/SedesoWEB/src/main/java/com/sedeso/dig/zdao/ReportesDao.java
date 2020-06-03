package com.sedeso.dig.zdao;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sedeso.dig.service.HomeService;

@Component("reportesDao")
public class ReportesDao implements IReportesDao{
	private final Logger logger = LoggerFactory.getLogger(IReportesDao.class);

	@Override
	public List<String> consultaDirReporte(String user) throws Exception {
		// TODO Auto-generated method stub
		List<String> a= new ArrayList<String>();
		File ruta = new File("D:\\Reportes\\"+user);
		if (ruta.exists()){
			logger.info(ruta.toString());
			logger.info(user);
			
			File[] archivos = ruta.listFiles();
			FileFilter filtro = new FileFilter() {
				@Override
				public boolean accept(File arch) {
					return arch.isFile();
				}
			};
			archivos  = ruta.listFiles(filtro);
			if(archivos == null || archivos.length ==0)
			{
				a.add("Sin archivos");
				return a;
			}	
			else {
				SimpleDateFormat sdf= new  SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
				for(int i=0; i<archivos.length; i++) {
					File archivo = archivos[i];	
					a.add(archivo.getAbsolutePath());
				}
			}
		}
		else {
			a.add("Sin archivos");
			return a;
		}
		return a;
	}

}
