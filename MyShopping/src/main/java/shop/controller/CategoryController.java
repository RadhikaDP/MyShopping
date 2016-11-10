package shop.controller;

import java.sql.SQLException;
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

import shop.bean.Category;
import shop.service.CategoryService;
import shop.validate.WarningMsg;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
    @RequestMapping(value = "/categoryHome",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res,Category cat){
    	
    	ModelAndView model=new ModelAndView("categoryhome");
    	model.addObject("category",cat);
		return model;
    }

	@RequestMapping("/category")
	public ModelAndView getUserList(HttpServletRequest request,HttpServletResponse response,Category cat) {			
					List<Category> category = catService.getUserList();				
					return new ModelAndView("category", "category", category);				
	}
	
	   @RequestMapping(value="/editcategory/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        Category cat=catService.getcategoryId(id);  
	        return new ModelAndView("editcategory","command",cat);  
	    } 
	   @RequestMapping(value="/deletecategory/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   catService.delete(id);  
	        return new ModelAndView("redirect:/category");  
	    } 
	    @RequestMapping(value="/editsavecategory",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("category") Category cat){  
	    	try{
	    	catService.update(cat);  
	    	}
	    	catch(Exception e){
	    	String msg ="Category Already Exists";
	    	WarningMsg.showDialog(msg);
	    	}
	        return new ModelAndView("redirect:/category");  
	    }
	    
	    @RequestMapping(value="/categoryform",method = RequestMethod.GET)  
	    public ModelAndView showform( Category cat){  
	        return new ModelAndView("categoryform","command",cat);  
	    } 
	    
	    @RequestMapping(value="/savecategory",method = RequestMethod.POST)  
	    public ModelAndView save(@Valid @ModelAttribute("category") Category cat,BindingResult result) {  
	      	if (result.hasErrors()) {
	    		
	    		ModelAndView model=new ModelAndView("categoryform");	
		    	model.addObject("login",cat);
		    	return model;
	    	 
	    	}
	    	try{
	    	catService.save(cat);  
	    	}
	    	catch(Exception e){
				String msg="Category Already Exists";
				WarningMsg.showDialog(msg);
			}
	        return new ModelAndView("redirect:/category");
	    }
}
