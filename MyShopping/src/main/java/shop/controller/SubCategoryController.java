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


import shop.bean.SubCategory;
import shop.service.SubCategoryService;
import shop.validate.WarningMsg;


@Controller
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subService;

	@RequestMapping("/subcategory")
	public ModelAndView getUserList(HttpServletRequest request,HttpServletResponse response,SubCategory cat) {			
				//returns collection of subcategory
		List<SubCategory> subcategory = subService.getList();				
					return new ModelAndView("subcategory", "subcategory", subcategory);				
	}
	/**
	 * 
	 * @param id : id of subcategory from jsp page taken as pathvariable.
	 * @return
	 */
	   @RequestMapping(value="/editsubcategory/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
		   //returns subcategory with given id
	        SubCategory cat=subService.getsubcategoryId(id);  
	        return new ModelAndView("editsubcategory","command",cat);  
	    } 
	   /**
	    * 
	    * @param id : id of subcategory from jsp page taken as pathvariable.
	    * @return
	    */
	   @RequestMapping(value="/deletesubcategory/{id}",method = RequestMethod.GET)  
	   
	   public ModelAndView delete(@PathVariable int id){  
		   //deletes subcategory with given id .
		   subService.delete(id);  
	        return new ModelAndView("redirect:/subcategory");  
	    } 
	   
	    @RequestMapping(value="/editsavesubcategory",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("subcategory") SubCategory cat){  
	    	
	    	//updates subcategory with edited values.
	    	subService.update(cat);  
	        return new ModelAndView("redirect:/subcategory");  
	    }
	    
	    @RequestMapping("/subcategoryform")  
	    public ModelAndView showform(@ModelAttribute("command") SubCategory cat){  
	    	//returns list of all categories from category table
	    	List<String> category = subService.getallcategory();
	    	return new ModelAndView("subcategoryform", "category", category);		
	      
	    } 
	    
	    @RequestMapping(value="/savesubcategory",method = RequestMethod.POST)  
	    public ModelAndView save(@Valid @ModelAttribute("command") SubCategory cate,BindingResult result) {  
	    	if (result.hasErrors()) {
	    		
	    		ModelAndView model=new ModelAndView("subcategoryform");	
	        	//returns list of all categories from category table
	    		List<String> category = subService.getallcategory();
		    	model.addObject("category",category);
		    	return model;
	    	 
	    	}
	    	   
	    	  try{
	    	      subService.save(cate,cate.getCategory(),cate.getSubcategory());  
	    	  }
	    	  catch(Exception e){
	    		  
	    		  String msg="subcategory already exists";
					WarningMsg.showDialog(msg);
	    	  }
	    	  
	        return new ModelAndView("redirect:/subcategory");
	    	  
	    }
	
}
