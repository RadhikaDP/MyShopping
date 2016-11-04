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
import shop.bean.SubCategory2;
import shop.bean.Users;
import shop.service.CategoryService;
import shop.service.LoginService;
import shop.service.SubCategory2Service;
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
	private SubCategory2Service subService2;
	
    @RequestMapping(value = "/login",method = RequestMethod.GET)

    public ModelAndView registeringProcess(HttpServletRequest request,HttpServletResponse res,Login login){
    	
    	ModelAndView model=new ModelAndView("login");
    	model.addObject("login",login);
    	logger.info("Registration model created");
    	return model;
    }
   
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView processLogin(@Valid @ModelAttribute("login") Login login,BindingResult result,Users reg,HttpServletRequest request,HttpServletResponse res) {
    	
    	if (result.hasErrors()) {
    		
    		ModelAndView model=new ModelAndView("login");	
	    	model.addObject("login",login);
	    	return model;
    	 
    	}
		try {
			
			
			boolean islogSuccesful = logService.authenticateUser(login);
		
				if (islogSuccesful) {
				
					 HttpSession session=request.getSession();  
					 String username=login.getUsername(); //Creating Session for the User
			         session.setAttribute("name",username );
					
					logger.info(" successfull");
					List<Category> category = catService.getUserList();	
					List<SubCategory> sub = subservice.getList();
					List<SubCategory2> sub2 = subService2.getList();
			    	ModelAndView model=new ModelAndView("user");			    	
			    	model.addObject("category",category);
			    	model.addObject("sub",sub);
			    	model.addObject("sub2",sub2);
			    	
			    	return model;
									
					} 
				else {

				logger.info(" failed");
				
				String msg="Invalid Credentials";
				WarningMsg.showDialog(msg);
		    	ModelAndView model=new ModelAndView("login");	
		    	model.addObject("login",login);
		    	return model;					    	
			}

		} 
		catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return null;


    }
    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)

    public ModelAndView LogoutProcess(HttpServletRequest req,HttpServletResponse res){
    	
    	HttpSession session  = req.getSession();
    	  session.removeAttribute("name");
    	  session.invalidate();  
    	  return new ModelAndView("redirect:login");  
    }

}
