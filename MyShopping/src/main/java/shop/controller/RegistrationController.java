package shop.controller;

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

import shop.bean.Login;
import shop.bean.Users;
import shop.service.RegService;

@Controller
public class RegistrationController {

	private Logger logger=Logger.getLogger(RegistrationController.class);
	
		@Autowired
	   private RegService regService;
	    @RequestMapping(value = "/registration",method = RequestMethod.GET)

	    public ModelAndView registeringProcess(HttpServletRequest request,HttpServletResponse res,Users reg){
	    	
	    	ModelAndView model=new ModelAndView("registration");
	    	model.addObject("registration",reg);
	    	logger.info("Registration model created");
	    	return model;
	    }
	    
	    @RequestMapping(value="/registration",method = RequestMethod.POST)
	    public ModelAndView processRegistration(@Valid @ModelAttribute("registration") Users reg, BindingResult result,Login log) {
	     
	    	if(result.hasErrors()){
	    		ModelAndView model=new ModelAndView("registration");
	    		return model;
	    	}
	    	
			try {

				boolean isRegSuccesful = regService.isRegSuccesful(reg);
			
					if (isRegSuccesful) {
					
						logger.info("Registration successfull");
			    		ModelAndView model=new ModelAndView("login");
			    		model.addObject("login",log);
			    		return model;
					
		
				} else {
								
					logger.info("Registration failed");
		    		ModelAndView model=new ModelAndView("registration");
		    		return model;
					
		    		}

			} catch (Exception e) {
		
				e.printStackTrace();
			}
			
			return null;


	    }
}
