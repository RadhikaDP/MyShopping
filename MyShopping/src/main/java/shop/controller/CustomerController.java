package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.bean.Users;
import shop.service.CustomerService;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService custService;
	
    @RequestMapping(value = "/customer",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res,Users user){
    	
    	ModelAndView model=new ModelAndView("customer");
    	model.addObject("user",user);
    	return model;
    }
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("user") Users user){  
    	custService.update(user);  
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
    public ModelAndView save(@ModelAttribute("user") Users user) throws Exception{  
    	custService.save(user);  
        return new ModelAndView("redirect:/viewcustomer");
    } 
    
    @RequestMapping("/viewcustomer")  
    public ModelAndView viewemp(){  
        List<Users> list=custService.getCustomers();  
    	ModelAndView model=new ModelAndView("viewcustomer","list",list);
    	return model;
    }
    
    @RequestMapping("/customerform")  
    public ModelAndView showform(){  
        return new ModelAndView("customerform","command",new Users());  
    } 
}
