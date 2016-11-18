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
	
    /**
     * 
     * @param user : user model with user model attributes.
     * If user already exists , then redirected to customer form.
     */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("user") Users user){  
    	try{
    		//updates user details.
    	custService.update(user);  
    	}
      	catch(Exception e){
			String msg="User Already Exists";
			WarningMsg.showDialog(msg);
			 return new ModelAndView("redirect:/customerform");  
		}
        return new ModelAndView("redirect:/viewcustomer");  
    }
    
  /**
   * 
   * @param id : customer id passed from jsp page as pathVariable.
   * @return 
   */
    @RequestMapping(value="/editcust/{id}")  
    public ModelAndView edit(@PathVariable int id){  
    	//returns user details of user having userid as id.
        Users user=custService.getEmpById(id);  
        return new ModelAndView("editcustomer","command",user);  
    } 
    /**
     * 
     * @param id : customer id passed from jsp page as pathVariable.
     * @return
     */
    @RequestMapping(value="/deletecust/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
    	custService.delete(id);  
        return new ModelAndView("redirect:/viewcustomer");  
    }  
 
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@Valid @ModelAttribute("registration") Users user,BindingResult result,HttpServletRequest request,HttpServletResponse res) throws Exception{  
    	
    	if (result.hasErrors()) {
    		//If binding result has errors it will return error message .
    		ModelAndView model=new ModelAndView("customerform");	
	    	model.addObject("user",user);
	    	return model;
    	 
    	}
    	
    	
    	try{
    		//inserts user details into user table.
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
    	//returs collection of all users .
        List<Users> list=custService.getCustomers();  
    	ModelAndView model=new ModelAndView("viewcustomer","list",list);
    	return model;
    }
    /*
     * returs model and view of customerform with user model.
     */
    @RequestMapping("/customerform")  
    public ModelAndView showform(  @ModelAttribute("registration") Users user){  
        return new ModelAndView("customerform","command",user);  
    } 
}
