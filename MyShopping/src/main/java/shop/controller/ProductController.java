package shop.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.bean.Address;
import shop.bean.CreditCard;
import shop.bean.Product;
import shop.bean.SubCategory2;
import shop.bean.Users;
import shop.service.ProductService;
import shop.service.SubCategory2Service;


@Controller
public class ProductController {
	
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
	    	pService.update(cat);  
	        return new ModelAndView("redirect:/product");  
	    }
	    
	    @RequestMapping("/productform")  
	    public ModelAndView showform(){  
	        return new ModelAndView("productform","command",new Product());  
	    } 
	    
	    @RequestMapping(value="/saveproduct",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("product") Product cat) throws Exception{  
	    	pService.save(cat);  
	        return new ModelAndView("redirect:/product");
	    }
	    
	
	    @RequestMapping(value="/displayProducts/{id}",method = RequestMethod.GET)  
	    public ModelAndView displayProducts(HttpServletRequest request,HttpServletResponse res,@PathVariable int id){
	    	
	    	
	    	ModelAndView model=new ModelAndView("displayProducts");
	    	List<Product> sub2 = pService.getProductList(id);
	    	model.addObject("sub2",sub2);	 
	    	
			return model;
	    }
		
    @RequestMapping(value="/displayProducts/buynow/{id}",method = RequestMethod.GET)  
	    public ModelAndView AddToCart(HttpServletRequest request,HttpServletResponse res,@PathVariable int id){
	    	
	    	ModelAndView model=new ModelAndView("buynow");
	    	List<Product> sub2 = pService.getProductList(id);
	    	model.addObject("sub2",sub2);	    	
			return model;
	    }
    @RequestMapping(value="/displayProducts/buynow/address",method = RequestMethod.GET)  
    public ModelAndView checkout(@ModelAttribute("address") Address ad){  
    	ModelAndView model=new ModelAndView("address");   
    	model.addObject(ad);
		return model;
          
    }
    @RequestMapping(value="/displayProducts/buynow/billing",method = RequestMethod.GET)  
    public ModelAndView billing(@ModelAttribute("creditcard") CreditCard cd){  
    	ModelAndView model=new ModelAndView("billing");   
    	model.addObject(cd);
		return model;
          
    }
    @RequestMapping(value="/displayProducts/buynow/ordersuccess",method = RequestMethod.GET)  
    public ModelAndView placeOrder(){  
    	ModelAndView model=new ModelAndView("ordersuccess");   
		return model;
          
    }
}
