package shop.controller;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * AdminController.java: defined under shop.controller package
 * AdminController is a controller class to handle requests for adminPage.
 * Here administrator Can view product,customer,category section
 *
 */
@Controller
public class AdminController {
	
	private Logger logger=Logger.getLogger(AdminController.class);
	  
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
    	  session.removeAttribute("role");
    	  session.invalidate();  
    	  logger.info("admin session out");
    	  return new ModelAndView("redirect:login");  
    	  
    }
}
