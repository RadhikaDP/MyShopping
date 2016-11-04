package shop.controller;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import shop.bean.Cart;
import shop.bean.Product;
import shop.service.CartService;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.validate.WarningMsg;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService pService;
	
	   @RequestMapping(value="MyShopping/order",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   orderService.getOrders();  
	        return new ModelAndView("redirect:/myorder");  
	    }  
	   
	   @RequestMapping(value="/displayProducts/addcart/{id}/{proname}/{sub2id}",method = RequestMethod.GET)  
	    public ModelAndView addtocart(@PathVariable int id,@PathVariable int sub2id,@PathVariable String proname,HttpServletRequest request,HttpServletResponse res, HttpSession session ){  	
		   session  = request.getSession(false);
		  String username= (String) session.getAttribute("name");	   		 		
		 
		   cartService.save(id,username,proname);
		   

		 
		 
		 return new ModelAndView("redirect:/displayProducts/"+sub2id); 
	    }  
	   
	   @RequestMapping(value="/viewcart",method = RequestMethod.GET)  
	    public ModelAndView viewcart(HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
		   session  = request.getSession(false);
		   String username= (String) session.getAttribute("name");
	         ModelAndView model = new ModelAndView("viewcart");
	    	    List<Cart> cart = cartService.getCartproducts(username);      	    
	    	    model.addObject("cart",cart);	    	    	    	     	  
	         return model;
	    }  
	   
	   @RequestMapping(value="/deletcart/{id}",method = RequestMethod.GET)  
	    public ModelAndView removefromcart(@PathVariable int id,HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
		  
	    	     cartService.delete(id);  
	    	   
	    	     return new ModelAndView("redirect:/viewcart"); 
	    }  
}
