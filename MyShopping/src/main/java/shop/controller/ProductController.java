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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.bean.Address;
import shop.bean.CreditCard;
import shop.bean.Product;
import shop.bean.SubCategory;
import shop.service.CategoryService;
import shop.service.ProductService;
import shop.service.SubCategory2Service;
import shop.service.SubCategoryService;
import shop.validate.WarningMsg;


@Controller
public class ProductController {
	
	@Autowired
	private SubCategoryService subService;
	@Autowired
	private ProductService pService;
	
	@Autowired
	private SubCategory2Service subService2;
	
	
    private Logger logger=Logger.getLogger(ProductController.class);
    @RequestMapping(value = "/productHome",method = RequestMethod.GET)

    public ModelAndView LoginProcess(HttpServletRequest request,HttpServletResponse res,Product cat){
    	
    	ModelAndView model=new ModelAndView("productHome");
    	model.addObject("product",cat);
    	logger.info("productHome model created");
		return model;
    }

	@RequestMapping("/product")
	public ModelAndView getUserList(HttpServletRequest request,HttpServletResponse response,Product cat) {			
					List<Product> product = pService.getList();				
					return new ModelAndView("product", "product", product);				
	}
	
	   @RequestMapping(value="/editproduct/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
		   Product cat=pService.getProductById(id);  
	        return new ModelAndView("editproduct","command",cat);  
	    } 
	   @RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   pService.delete(id);  
	        return new ModelAndView("redirect:/product");  
	    } 
	    @RequestMapping(value="/editsaveproduct",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("product") Product cat){  
	    	try{
	    	pService.update(cat);  
	    	}
	      	catch(Exception e){
				String msg="Product Already Exists";
				WarningMsg.showDialog(msg);
				
			}
	        return new ModelAndView("redirect:/product");  
	    }
	    
	    @RequestMapping(value="/productform",method=RequestMethod.GET)  
	    public ModelAndView showform(@ModelAttribute("product") Product cat){  
	    	
	    	List<SubCategory> subcategory = subService.getList();	
	    	return new ModelAndView("productform", "subcategory", subcategory);		

	        
	    } 
	    
	    @RequestMapping(value="/saveproduct",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("product") Product cat) throws Exception{  
	    	try{
	    	pService.save(cat);  
	    	}
	    	catch(Exception e){
				String msg="Brand Already Exists";
				WarningMsg.showDialog(msg);
			}
	        return new ModelAndView("redirect:/product");
	    }
	    
	
	    @RequestMapping(value="/displayProducts/{id}",method = RequestMethod.GET)  
	    public ModelAndView displayProducts(HttpServletRequest request,HttpServletResponse res,@PathVariable int id,HttpSession session){
	    	
	    	
	    	ModelAndView model=new ModelAndView("displayProducts");
	    	List<Product> sub2 = pService.getProductList(id);
	    	  session  = request.getSession(false);
			  String username= (String) session.getAttribute("name");	
	    	model.addObject("sub2",sub2);	 
	    	
	    	model.addObject(username);
			return model;
	    }
		
	    
    @RequestMapping(value="/displayProducts/buynow/{id}",method = RequestMethod.GET)  
	    public ModelAndView AddToCart(HttpServletRequest request,HttpServletResponse res,@PathVariable int id){
	    	
	    	ModelAndView model=new ModelAndView("buynow");
	    	List<Product> sub2 = pService.getProductList(id);
	    	model.addObject("sub2",sub2);	    	
			return model;
	    }
    @RequestMapping(value="/displayProducts/buynow/{id}/{ids}",method = RequestMethod.GET)  
    public ModelAndView producttobuy(HttpServletRequest request,HttpServletResponse res,@PathVariable int ids){
    	
    	ModelAndView model=new ModelAndView("buynow");
    	Product pro =  pService.getProductById(ids);
    	model.addObject("pro",pro);	    	
		return model;
    }
    
    @RequestMapping(value="address",method = RequestMethod.POST)  
    public ModelAndView getcheckout(HttpServletRequest request,HttpServletResponse res, @ModelAttribute("order") Address ad,BindingResult result){  
    	
    	if(result.hasErrors()){
    		ModelAndView model=new ModelAndView("address");
    		return model;
    	}
    	ModelAndView model=new ModelAndView("address");   
    	model.addObject(ad);
		return model;
          
    }
    @RequestMapping(value="/displayProducts/buynow/address1",method = RequestMethod.POST)  
    public ModelAndView checkout(HttpServletRequest request,HttpServletResponse res,@Valid @ModelAttribute("creditcard") CreditCard cd){  
    	ModelAndView model=new ModelAndView("billing"); 
    	model.addObject(cd);
		return model;
          
    }
    
      @RequestMapping(value="/displayProducts/buynow/billing",method = RequestMethod.POST)  
      public ModelAndView billing(HttpServletRequest request,HttpServletResponse res){  
    	ModelAndView model=new ModelAndView("ordersuccess");   
		return model;
          
    }
    @RequestMapping(value="/displayProducts/buynow/ordersuccess",method = RequestMethod.POST)  
    public ModelAndView placeOrder(HttpServletRequest request,HttpServletResponse res){  
    	ModelAndView model=new ModelAndView("ordersuccess");   
		return model;
          
    }
}
