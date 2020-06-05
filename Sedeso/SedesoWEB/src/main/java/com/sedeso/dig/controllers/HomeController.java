package com.sedeso.dig.controllers;

import com.sedeso.dig.service.HomeService;
import com.sedeso.dig.service.IFilesService;
import com.sedeso.dig.service.IHomeService;
import com.sedeso.dig.zdao.ListaDirectorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private IHomeService iHomeService;
	
	
	@Autowired
	private IFilesService iFileService;
	
	
	@GetMapping( value ="homes")
	public String getHome(){
		return "home";
	}
	@GetMapping( value ="reportes")
	public String getReportes(){
		return "reportes";
	}
	
	//Reportes
	@PostMapping(value="reportes/upload")
	public String uploadFileCuerna(
			@RequestParam("fotoUno") MultipartFile fotoUnos,
			@RequestParam("fotoDos") MultipartFile fotoDoss,
			@RequestParam("fotoTres") MultipartFile fotoTress,
			@RequestParam("fotoCuatro") MultipartFile fotoCuatros,
			@RequestParam("fotoCinco") MultipartFile fotoCincos,
			
			@RequestParam("nombBenef") String nombBenef,
			@RequestParam("telContact") String telContact,
			@RequestParam("email") String email,
			@RequestParam("beneficiariosDom") String beneficiariosDom,
			@RequestParam("observVisit") String observVisit,
			@RequestParam("usuario") String usuario,
			
			Model model
			) throws Exception{
		if(iFileService.insertFiles(fotoUnos, fotoDoss, fotoTress, fotoCuatros, fotoCincos,nombBenef, telContact, email, beneficiariosDom, observVisit, usuario)){			
			model.addAttribute("resultado", "OK");
		}else{
			model.addAttribute("resultado", "NOK");
		}
		
		return "estatusReportes";
	}

	@ResponseBody
	@GetMapping( value ="consultaReportes")
	public List<String> getReportes(Model model,@ModelAttribute("usuario") String user ) throws Exception {
		//ModelAndView modeviewl = new ModelAndView("reportes");
		List<String> lista = new ArrayList<String>();
		//lista.add("a");
		
		lista=	iHomeService.consultaReporte(user);
		//modeviewl.addObject("lista", a);
		return lista;
		
	}

	
    @Autowired
    ServletContext context;
 
    @RequestMapping(value="download",method = RequestMethod.GET)
    public void downloader(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("url") String url) {
        try {
            //String downloadFolder = context.getRealPath("/Users/artemiooleacatalan/Desktop");
            //File file = new File(downloadFolder + File.separator + fileName);
            File file = new File (url);
 
            if (file.exists()) {
                String mimeType = context.getMimeType(file.getPath());
 
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                int inicio =url.lastIndexOf("\\");
                String fin =url.substring(inicio+1);
 
                response.setContentType(mimeType);
                response.addHeader("Content-Disposition", "attachment; filename=" + fin);
                response.setContentLength((int) file.length());
 
                OutputStream os = response.getOutputStream();
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int b = -1;
 
                while ((b = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, b);
                }
 
                fis.close();
                os.close();
            } else {
                System.out.println("Requested " + url + " file not found!!");
            }
        } catch (IOException e) {
            System.out.println("Error:- " + e.getMessage());
        }
    }
	
	
	
}
