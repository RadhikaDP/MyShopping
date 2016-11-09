package shop.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.bean.SubCategory2;
import shop.service.SubCategory2Service;



@Controller
public class SubCategory2Controller {
	
	@Autowired
	private SubCategory2Service subService2;

	@RequestMapping("/subcategory2")
	public ModelAndView getUserList(HttpServletRequest request,HttpServletResponse response,SubCategory2 cat) {			
					List<SubCategory2> subcategory = subService2.getList();				
					return new ModelAndView("subcategory2", "subcategory", subcategory);				
	}
	   @RequestMapping(value="/editsubcategory2/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        SubCategory2 cat=subService2.getsubcategoryId(id);  
	        return new ModelAndView("editsubcategory2","command",cat);  
	    } 
	   @RequestMapping(value="/deletesubcategory2/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   subService2.delete(id);  
	        return new ModelAndView("redirect:/subcategory2");  
	    } 
	    @RequestMapping(value="/editsavesubcategory2",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("subcategory2") SubCategory2 cat){  
	    	subService2.update(cat);  
	        return new ModelAndView("redirect:/subcategory2");  
	    }
	    
	    @RequestMapping("/subcategoryform2")  
	    public ModelAndView showform(){  
	        return new ModelAndView("subcategoryform2","command",new SubCategory2());  
	    } 
	    
	    @RequestMapping(value="/savesubcategory2",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("subcategory2") SubCategory2 cat,BindingResult result) throws Exception{  
	    	 boolean error = false;
	    	   if(cat.getSubcategory().isEmpty()){
	    	        result.rejectValue("category", "error.category");
	    	        error = true;
	    	    }
	    	    if(error) {
	    	    	return new ModelAndView("redirect:/subcategoryform2");
	    	       
	    	    }
	    	subService2.save(cat);  
	        return new ModelAndView("redirect:/subcategory2");
	    }
}
