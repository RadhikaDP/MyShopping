package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.bean.Users;
import shop.service.CustomerService;
import shop.validate.WarningMsg;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService custService;
	
    @RequestMapping(value = "/customer",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res, Users user){
    	
    	ModelAndView model=new ModelAndView("customer");
    	model.addObject("user",user);
    	return model;
    }
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("user") Users user){  
    	try{
    	custService.update(user);  
    	}
      	catch(Exception e){
			String msg="User Already Exists";
			WarningMsg.showDialog(msg);
			 return new ModelAndView("redirect:/customerform");  
		}
        return new ModelAndView("redirect:/viewcustomer");  
    }
    
    @RequestMapping(value="/editcust/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Users user=custService.getEmpById(id);  
        return new ModelAndView("editcustomer","command",user);  
    } 
    
    @RequestMapping(value="/deletecust/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
    	custService.delete(id);  
        return new ModelAndView("redirect:/viewcustomer");  
    }  
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@Valid @ModelAttribute("registration") Users user,BindingResult result,HttpServletRequest request,HttpServletResponse res) throws Exception{  
    	
    	if (result.hasErrors()) {
    		
    		ModelAndView model=new ModelAndView("customerform");	
	    	model.addObject("user",user);
	    	return model;
    	 
    	}
    	
    	
    	try{
    	custService.save(user);  
    	}
      	catch(Exception e){
			String msg="User Already Exists";
			WarningMsg.showDialog(msg);
			 return new ModelAndView("redirect:/customerform");  
		}
        return new ModelAndView("redirect:/viewcustomer");
    } 
    
    @RequestMapping("/viewcustomer")  
    public ModelAndView viewemp(){  
        List<Users> list=custService.getCustomers();  
    	ModelAndView model=new ModelAndView("viewcustomer","list",list);
    	return model;
    }
    
    @RequestMapping("/customerform")  
    public ModelAndView showform(  @ModelAttribute("registration") Users user){  
        return new ModelAndView("customerform","command",user);  
    } 
}
