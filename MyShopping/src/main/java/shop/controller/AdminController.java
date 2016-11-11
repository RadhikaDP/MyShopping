package shop.controller;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

/**
 * AdminController.java: defined under shop.controller package
 * AdminController is a controller class to handle requests for adminPage.
 * Here administrator Can view product,customer,category section
 *
 */
@Controller
public class AdminController {
	
	private Logger logger=Logger.getLogger(AdminController.class);
	
	/**
	 *  @Autowired annotation can be used to auto wire bean .
	 *  @Autowired annotation on properties to get rid of the setter methods. 
	 *  When you will pass values of autowired properties using <property> 
	 *  Spring will automatically assign those properties with the passed values or references.
	 *  
	 */
	@Autowired
	   private AdminService adminService;
	
	  /** RequestMapping handles admin URL  under GET request to display admin login page.
	   *  AdminPage model is created and returned.
		  *  
		  * 
		  */
    @RequestMapping(value = "/admin",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res,Admin login){
    	
    	ModelAndView model=new ModelAndView("adminLogin");
    	model.addObject("admin",login);
    	return model;
    }
    
   /** 
	  * @param request on HttpServletRequest used to get HttpSession
	  * @param admin  used to send admin username and password.
	  * @param result  used to check errors.
	  */
    
    @RequestMapping(value="/admin",method = RequestMethod.POST)
    public ModelAndView processLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("admin")@Valid Admin admin,BindingResult result) {

    	/**
		 * If there is errors in binding result admin is redirected to adminlogin page.
		 * adminlogin model is created and returned.
		 */
	if (result.hasErrors()) {
    	
    		ModelAndView model=new ModelAndView("adminLogin");	
	    	return model;
    	 
    	}
	  /**  authenticateUser method : This method is executed when a administrator logs in to check whether admin is authentic.
		  * @param islogSuccesful return true if admin exist else it will false.
		  * @param admin  used to send admin username and password.
		  * If Admin credentials are invalid then admin will be redirected to login page.
		  */
			boolean islogSuccesful;
			try {
				islogSuccesful = adminService.authenticateUser(admin);
				if (islogSuccesful) {
					 HttpSession session=request.getSession();  
					 String username=admin.getUsername(); 
			         session.setAttribute("name",username );
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
    
    @RequestMapping(value = "contact",method = RequestMethod.GET)

    public ModelAndView ContactProcess(HttpServletRequest request,HttpServletResponse res){
    	
    	ModelAndView model=new ModelAndView("contact");
    	return model;
    }
    @RequestMapping(value = "about",method = RequestMethod.GET)

    public ModelAndView AboutProcess(HttpServletRequest request,HttpServletResponse res){
    	
    	ModelAndView model=new ModelAndView("about");
    	return model;
    }
    /**
     * admin session is invalidated and session attributes are removed.
     * redirected to admin login page.
     */
    @RequestMapping(value = "/adminlogout",method = RequestMethod.GET)

    public ModelAndView adminlogout(HttpServletRequest req,HttpServletResponse res){
    	
    	HttpSession session  = req.getSession();
    	  session.removeAttribute("name");
    	  session.invalidate();  
    	  return new ModelAndView("redirect:admin");  
    }
}
