package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.bean.Cart;
import shop.bean.Product;
import shop.bean.Users;
import shop.service.CartService;
import shop.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	   @RequestMapping(value="/order",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		   orderService.getOrders();  
	        return new ModelAndView("redirect:/myorder");  
	    }  
	   
	   @RequestMapping(value="/displayProducts/addcart/{id}",method = RequestMethod.GET)  
	    public ModelAndView addtocart(@PathVariable int id,Users user,Product p){  
		int userid=user.getId();
		 int proid= p.getId();
		   cartService.save(proid,userid);
	        return new ModelAndView("redirect:/displayProducts/{id}");  
	    }  
	   
}
