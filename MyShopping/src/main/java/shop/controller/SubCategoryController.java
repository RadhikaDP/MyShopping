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


import shop.bean.SubCategory;
import shop.service.SubCategoryService;
import shop.validate.WarningMsg;


@Controller
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subService;

	@RequestMapping("/subcategory")
	public ModelAndView getUserList(HttpServletRequest request,HttpServletResponse response,SubCategory cat) {			
					List<SubCategory> subcategory = subService.getList();				
					return new ModelAndView("subcategory", "subcategory", subcategory);				
	}
	   @RequestMapping(value="/editsubcategory/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        SubCategory cat=subService.getsubcategoryId(id);  
	        return new ModelAndView("editsubcategory","command",cat);  
	    } 
	   @RequestMapping(value="/deletesubcategory/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   subService.delete(id);  
	        return new ModelAndView("redirect:/subcategory");  
	    } 
	    @RequestMapping(value="/editsavesubcategory",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("subcategory") SubCategory cat){  
	    	subService.update(cat);  
	        return new ModelAndView("redirect:/subcategory");  
	    }
	    
	    @RequestMapping("/subcategoryform")  
	    public ModelAndView showform(){  
	        return new ModelAndView("subcategoryform","command",new SubCategory());  
	    } 
	    
	    @RequestMapping(value="/savesubcategory",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("subcategory") SubCategory cat,BindingResult result) {  
	    	 boolean error = false;
	    	   if(cat.getCategory().isEmpty()){
	    	        result.rejectValue("category", "error.category");
	    	        error = true;
	    	    }
	    	    if(error) {
	    	    	return new ModelAndView("redirect:/subcategoryform");
	    	       
	    	    }
	    	  try{
	    	      subService.save(cat);  
	    	  }
	    	  catch(Exception e){
	    		  
	    		  String msg="select existing category and new subcategory";
					WarningMsg.showDialog(msg);
	    	  }
	    	  
	        return new ModelAndView("redirect:/subcategory");
	    	  
	    }
}
