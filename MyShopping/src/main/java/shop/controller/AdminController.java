package shop.controller;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.validate.WarningMsg;
import shop.bean.Admin;
import shop.service.AdminService;


@Controller
public class AdminController {
	
	private Logger logger=Logger.getLogger(AdminController.class);
	
	@Autowired
	   private AdminService adminService;
    @RequestMapping(value = "/admin",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res,Admin login){
    	
    	ModelAndView model=new ModelAndView("adminLogin");
    	model.addObject("admin",login);
    	return model;
    }
    
    @RequestMapping(value="/admin",method = RequestMethod.POST)
    public ModelAndView processLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("admin")@Valid Admin admin,BindingResult result) {

	if (result.hasErrors()) {
    		
    		ModelAndView model=new ModelAndView("adminLogin");	
	    	return model;
    	 
    	}
    	
			boolean islogSuccesful;
			try {
				islogSuccesful = adminService.authenticateUser(admin);
				if (islogSuccesful) {
					
					logger.info(" successfull");
					
			    	ModelAndView model=new ModelAndView("adminHome");			    
			    	return model;
									
					} 
				else {

				logger.info(" failed");
				String msg="Invalid credentials : Please try again ";
				WarningMsg.showDialog(msg);
		    	ModelAndView model=new ModelAndView("adminLogin");			    
		    	return model;			
		    	
			}
			} catch (SQLException e) {
				
				
			}		
		return null;


    }
    
    @RequestMapping(value = "/contact",method = RequestMethod.GET)

    public ModelAndView ContactProcess(HttpServletRequest request,HttpServletResponse res){
    	
    	ModelAndView model=new ModelAndView("contact");
    	return model;
    }
    @RequestMapping(value = "/about",method = RequestMethod.GET)

    public ModelAndView AboutProcess(HttpServletRequest request,HttpServletResponse res){
    	
    	ModelAndView model=new ModelAndView("about");
    	return model;
    }
}
