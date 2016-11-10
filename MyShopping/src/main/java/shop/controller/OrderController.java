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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import shop.bean.Address;
import shop.bean.Cart;
import shop.bean.CreditCard;
import shop.bean.Order;
import shop.service.CartService;
import shop.service.OrderService;
import shop.service.ProductService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;

	

	   
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
	   @RequestMapping(value="address/{proname:[a-zA-Z0-9\\s]*}/{price}",method = RequestMethod.POST)  
	    public ModelAndView getcheckout(HttpServletRequest request,HttpServletResponse res, @PathVariable("proname") String proname, @PathVariable("price") double price,@Valid @ModelAttribute("order") Order od,BindingResult result, HttpSession session , @ModelAttribute("address") Address ad){  
	    	
	    	if(result.hasErrors()){
	    		ModelAndView model=new ModelAndView("buynow");
	    		return model;
	    	}
	    	session  = request.getSession(false);
			  String username= (String) session.getAttribute("name");
	    	
	    	ModelAndView model=new ModelAndView("address");   
	    	int quantity = od.getQuantity();
	   
	    	orderService.Addorder(proname,username,quantity,price);
	    	
			return model;
	          
	    }
	
	    @RequestMapping(value="address1",method = RequestMethod.POST)  
	    public ModelAndView addaddress(HttpServletRequest request,HttpServletResponse res,@Valid @ModelAttribute("address")Address ad,BindingResult result){  
	    	if(result.hasErrors()){
	    		ModelAndView model=new ModelAndView("address");
	    		return model;
	    	}
	    	ModelAndView model=new ModelAndView("ordersuccess"); 
	    	orderService.addAddress(ad);
			return model;
	          
	    }

		   
		   @RequestMapping(value="vieworder",method = RequestMethod.GET)  
		    public ModelAndView vieworder(HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
			   session  = request.getSession(false);
			   String username= (String) session.getAttribute("name");
		         ModelAndView model = new ModelAndView("vieworders");
		    	    List<Order> order = orderService.getOrders(username);      	    
		    	    model.addObject("order",order);	    	    	    	     	  
		         return model;
		    }  
		   @RequestMapping(value="cancelOrder/{id}",method = RequestMethod.GET)  
		    public ModelAndView cancelorder(HttpServletRequest request,HttpServletResponse res,@PathVariable int id ){  		
		         ModelAndView model = new ModelAndView("cancelorder");
		         orderService.cancelorder(id);	    	   	    	     	  
		         return model;
		    }  
}
