package shop.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
	
	
	private Logger logger=Logger.getLogger(CategoryController.class);
	
	/**
	 * since catService is using serviceDao property , catService is autowired
	 */
	@Autowired
	private CategoryService catService;

	@RequestMapping("/category")
	public ModelAndView getcategory(HttpServletRequest request,HttpServletResponse response,Category cat) {			
		
		//getUserList() : returns collection of Category from category table
		List<Category> category = catService.getUserList();				
		logger.info("category model created");
		return new ModelAndView("category", "category", category);				
	}
	
	/**
	 * 
	 * @param id : id of the category to be edited.
	 * @return  ModelAndView of editcategory
	 */
	   @RequestMapping(value="/editcategory/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
		   // getcategoryId() returns category with given id from database.
	        Category cat=catService.getcategoryId(id);  
	        return new ModelAndView("editcategory","command",cat);  
	    } 
	   
	   /**
	    * 
	    * @param id : id of the category to be deleted.
	    * If the deletion is success, redirects to category form.
	    */
	   @RequestMapping(value="/deletecategory/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   
		   // delete() : delets category with id of @param id from database .
		   catService.delete(id);  
	        return new ModelAndView("redirect:/category");  
	    } 
	   
	   /**
	    * 
	    * @param cat : Data of category model is binded with cat and passed to editsave()
	    * @return
	    */
	    @RequestMapping(value="/editsavecategory",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("category") Category cat){  
	    	try{
	    		//updates() : updates category details with new values.
	    	catService.update(cat);  
	    	
	    	}
	    	catch(Exception e){
	    		// if category already exists it will return to same page.
	    	String msg ="Category Already Exists";
	    	WarningMsg.showDialog(msg);
	    	}
	    	// If updatation is success then user is redirected to category list page.
	        return new ModelAndView("redirect:/category");  
	    }
	  
	    @RequestMapping(value="/categoryform",method = RequestMethod.GET)  
	    public ModelAndView showform( Category cat){  
	        return new ModelAndView("categoryform","command",cat);  
	    } 
	    
	    /**
	     * 
	     * save() method : Inserts values to database.
	     * @param result : Binds the result with category bean . If there is any error user is redirected to categoryform.
	     * @return
	     */
	    @RequestMapping(value="/savecategory",method = RequestMethod.POST)  
	    public ModelAndView save(@Valid @ModelAttribute("category") Category cat,BindingResult result) {  
	      	if (result.hasErrors()) {
	    		
	    		ModelAndView model=new ModelAndView("categoryform");	
		    	model.addObject("login",cat);
		    	return model;
	    	 
	    	}
	    	try{
	    		// save() method : used to insert values to database.
	    	catService.save(cat);  
	    	}
	    	catch(Exception e){
				String msg="Category Already Exists";
				WarningMsg.showDialog(msg);
			}
	    	//on successfully adding to database user is redirected to category page.
	        return new ModelAndView("redirect:/category");
	    }
}
