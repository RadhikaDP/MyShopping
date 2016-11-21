package shop.controller;
import java.util.List;

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
import shop.bean.Category;
import shop.bean.Login;
import shop.bean.SubCategory;
import shop.bean.Users;
import shop.service.CategoryService;
import shop.service.LoginService;
import shop.service.RegService;
import shop.service.SubCategoryService;



@Controller
public class LoginController {
	
	private Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
    private LoginService logService;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private SubCategoryService subservice;

	
	@Autowired
	   private RegService regService;
	
	
	//login model is created and returned.
    @RequestMapping(value = "/login",method = RequestMethod.GET)

    public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse res,Login login){
    	     	
    	ModelAndView model=new ModelAndView("login");
    	model.addObject("login",login);

    	logger.info("login model created");
    	
    	//System.out.println(roles);
    	return model;
    }
    
    @RequestMapping(value = "/home",method = RequestMethod.GET)

    public ModelAndView gethomepage(HttpServletRequest request,HttpServletResponse res,Login login){
    	//returns collection of all  categories.
    	List<Category> category = catService.getUserList();	
    	//returns collection of all subcategories.
		List<SubCategory> sub = subservice.getList();
		ModelAndView model=new ModelAndView("home");
		model.addObject("category",category);		    	
    	model.addObject("sub",sub);	  
    	return model;
    }
    	/**
     	* 
     	* @param login :  modelattributes username and password.
  		* @param islogSuccesful  : returns true if user is authentic else returns false.
  		* If user enter in valid credentials then user will be redirected to login page.
  		* @return 
  		*/
    @RequestMapping(value={"/login"},method = RequestMethod.POST)
    public ModelAndView processLogin(@Valid @ModelAttribute("login") Login login,BindingResult result, Users reg,HttpServletRequest request,HttpServletResponse res) {
    	
    	if (result.hasErrors()) {
    		
    		ModelAndView model=new ModelAndView("login");	
	    	model.addObject("login",login);
	    	return model;
    	 
    	}
		try {
			
			HttpSession session= request.getSession(true);
			
			session.setMaxInactiveInterval(600);
			
			session.setAttribute("name", login.getUsername());		
			
			int userid = regService.getuserid(login.getUsername());
			
			String role = logService.getrole(userid);
			
			session.setAttribute("userid", userid);
			
			session.setAttribute("role", role);
			logger.info("role is selected");

			
			String user=(String) session.getAttribute("role");
			//String user="Customer";
			if(user.equals("Customer"))
			{
			boolean islogSuccesful = logService.authenticateUser(login);
		
				if (islogSuccesful) {
					
				boolean isactive = logService.isActive(login.getUsername(), reg);
		
				
				if(isactive){
					
					logger.info(" successfull");
					//returns collection of all  categories.
					List<Category> category = catService.getUserList();	
					//returns collection of all subcategories.
					List<SubCategory> sub = subservice.getList();
					ModelAndView model=new ModelAndView("home");
					model.addObject("category",category);		    	
			    	model.addObject("sub",sub);			    
			    	return model;
				}	
				else{
					String msg="session time out";
					WarningMsg.showDialog(msg);
			    	ModelAndView model=new ModelAndView("login");	
			    	model.addObject("login",login);
			    	return model;			
				}
					} 
				else {

				logger.info(" failed");
				
				String msg="Invalid Credentials";
				WarningMsg.showDialog(msg);
				ModelAndView model=new ModelAndView("redirect:login");	
				return model;
		    					    	
			}

		} 
			if(user.equals("admin")){
				boolean islogSuccesful;
				
					islogSuccesful = logService.authenticateUser(login);
					if (islogSuccesful) {
						 
						logger.info(" successfull");
						
				    	ModelAndView model=new ModelAndView("adminHome");			    
				    	return model;
										
						} 
					else {

					logger.info(" failed");
					String msg="Invalid credentials : Please try again ";
					WarningMsg.showDialog(msg);
			    	ModelAndView model=new ModelAndView("redirect:login");			    
			    	return model;			
			    	
					
			        }
		     	}
			}
		
		catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return null;


    }
    /**
     * user session is invalidated and session attributes are removed.
     * redirected to user login page.
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)

    public ModelAndView LogoutProcess(HttpServletRequest req,HttpServletResponse res){
    	
    	HttpSession session  = req.getSession();
    	  session.removeAttribute("name");
    	  session.removeAttribute("role");
    	  session.invalidate();  
    	  return new ModelAndView("redirect:login");  
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
    	  session.removeAttribute("role");
    	  session.invalidate();  
    	  logger.info("admin session out");
    	  return new ModelAndView("redirect:login");  
    	  
    }

}
