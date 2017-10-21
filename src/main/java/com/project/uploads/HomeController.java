package com.project.uploads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.uploads.dao.PhotoDao;
import com.project.uploads.model.Image;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static final String UPLOAD_DIRECTORY ="C:\\Users\\SPACE\\Documents\\workspace-sts-3.8.4.RELEASE\\uploads\\src\\main\\webapp\\resources\\uploads\\";
	
	@Autowired
	private PhotoDao pDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("pList", pDao.getAll());
		return "home";
	}
	
	@PostMapping(value = "/upload")
	public String postHome(@ModelAttribute Image i, @RequestParam CommonsMultipartFile file) throws IOException{
//		System.out.println("Fuck Me man...");
//		ServletContext context = session.getServletContext();  
//	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
//	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    FileOutputStream stream = new FileOutputStream(UPLOAD_DIRECTORY+filename); 
	    stream.write(bytes);  
	    i.setPhoto(filename);
	    stream.flush();  
	    stream.close();  
		i.setCreatedAt(new Date());
		pDao.addPhoto(i);
//		model.addAttribute("filesuccess", "Picture Uploaded Successfully!");
		return "redirect:/";
	}
	
}
