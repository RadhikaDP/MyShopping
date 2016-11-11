package shop.controller;


import java.math.BigDecimal;
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
import shop.bean.Order;
import shop.service.CartService;
import shop.service.OrderService;



@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;

	   /**
	    * 
	    * @param id : product id 
	    * @param sub2id : subcategory id
	    * @param proname : product name
	    * @param session : session is used to get session attribute.
	    * @return
	    */
	   @RequestMapping(value="/displayProducts/addcart/{id}/{proname}/{sub2id}",method = RequestMethod.GET)  
	    public ModelAndView addtocart(@PathVariable int id,@PathVariable int sub2id,@PathVariable String proname,HttpServletRequest request,HttpServletResponse res, HttpSession session ){  	
		   session  = request.getSession(false);
		  String username= (String) session.getAttribute("name");	   	
		  //inserts into cart.
		   cartService.save(id,username,proname);	 
		   //redirects back to product display page.
		 return new ModelAndView("redirect:/displayProducts/"+sub2id); 
	    }  
	   /**
	    * viewcart() method displays products added to cart
	    */
	   @RequestMapping(value="/viewcart",method = RequestMethod.GET)  
	    public ModelAndView viewcart(HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
		   session  = request.getSession(false);
		   String username= (String) session.getAttribute("name");
	         ModelAndView model = new ModelAndView("viewcart");
	         //returns collection of cart 
	    	    List<Cart> cart = cartService.getCartproducts(username);      	
	    	    
	    	    model.addObject("cart",cart);	    	    	    	     	  
	         return model;
	    }  
	   /**
	    * @param id : cart id used to delete product from cart.
	    */
	   @RequestMapping(value="/deletcart/{id}",method = RequestMethod.GET)  
	    public ModelAndView removefromcart(@PathVariable int id,HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
		   		//deletes product from cart
	    	     cartService.delete(id);  
	    	   
	    	     return new ModelAndView("redirect:/viewcart"); 
	    }  
	   /**
	    * 
	    * @param proname : product name 
	    * @param price : price of product 
	    * @param od	: object of type Order having modelAttribute order.
	    * @param ad : Object of type Address having modelAttribute address.
	    * @return
	    */
	   @RequestMapping(value="address/{proname:[a-zA-Z0-9\\s]*}/{price}",method = RequestMethod.POST)  
	    public ModelAndView getcheckout(HttpServletRequest request,HttpServletResponse res, @PathVariable("proname") String proname, @PathVariable("price") BigDecimal price,@Valid @ModelAttribute("order") Order od,BindingResult result, HttpSession session , @ModelAttribute("address") Address ad){  
	    	
	    	if(result.hasErrors()){
	    		ModelAndView model=new ModelAndView("buynow");
	    		return model;
	    	}
	    	session  = request.getSession(false);
			  String username= (String) session.getAttribute("name");
	    	
	    	ModelAndView model=new ModelAndView("address");   
	    	int quantity = od.getQuantity();
	    	int orderid = od.getId();
	    	System.out.println(orderid);
	    	if(quantity<0){
	    		ModelAndView model1=new ModelAndView("redirect:/home");
	    		return model1;
	    	}
	    	//inserts product details into order table.
	    	orderService.Addorder(proname,username,quantity,price);
	    	model.addObject("orderid",orderid);
			return model;
	          
	    }
	
	    @RequestMapping(value="address1",method = RequestMethod.POST)  
	    public ModelAndView addaddress(HttpServletRequest request,HttpServletResponse res,@Valid @ModelAttribute("address")Address ad,BindingResult result){  
	    	if(result.hasErrors()){
	    		ModelAndView model=new ModelAndView("address");
	    		return model;
	    	}
	    	ModelAndView model=new ModelAndView("ordersuccess"); 
	    	//inserts address details into address table.
	    	orderService.addAddress(ad);
			return model;
	          
	    }

		   /**
		    * displays All Order details of user.
		    */
		   @RequestMapping(value="vieworder",method = RequestMethod.GET)  
		    public ModelAndView vieworder(HttpServletRequest request,HttpServletResponse res,HttpSession session ){  
			   session  = request.getSession(false);
			   String username= (String) session.getAttribute("name");
		         ModelAndView model = new ModelAndView("vieworders");
		         // returns collection of Orders from order table of loged user.
		    	    List<Order> order = orderService.getOrders(username);      	    
		    	    model.addObject("order",order);	    	    	    	     	  
		         return model;
		    }  
		   /**
		    * Delets order from order table with given id .
		    * @param id : order id 
		    * @return
		    */
		   @RequestMapping(value="cancelOrder/{id}",method = RequestMethod.GET)  
		    public ModelAndView cancelorder(HttpServletRequest request,HttpServletResponse res,@PathVariable int id ){  		
		         ModelAndView model = new ModelAndView("cancelorder");
		         //deletes order 
		         orderService.cancelorder(id);	    	   	    	     	  
		         return model;
		    }  
}
