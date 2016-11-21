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

import shop.bean.Order;
import shop.bean.Product;
import shop.service.ProductService;
import shop.service.SubCategoryService;
import shop.validate.WarningMsg;

@Controller
public class ProductController {

	@Autowired
	private SubCategoryService subService;
	@Autowired
	private ProductService pService;

	private Logger logger = Logger.getLogger(ProductController.class);

	
	@RequestMapping("/product")
	public ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response, Product cat) {
		// returns collection products
		List<Product> product = pService.getList();
		return new ModelAndView("product", "product", product);
	}

	@RequestMapping(value = "/editproduct/{id}")
	public ModelAndView edit(@PathVariable int id) {
		// returns product based on product id
		Product cat = pService.getProductById(id);
		return new ModelAndView("editproduct", "command", cat);
	}

	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		// deletes product based on product id
		pService.delete(id);
		return new ModelAndView("redirect:/product");
	}

	@RequestMapping(value = "/editsaveproduct", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("product") Product cat) {
		try {
			// updates product with new product details passed through jsp page.
			pService.update(cat);
		} catch (Exception e) {
			String msg = "Product Already Exists";
			WarningMsg.showDialog(msg);

		}
		return new ModelAndView("redirect:/product");
	}

	@RequestMapping(value = "/productform", method = RequestMethod.GET)
	public ModelAndView showform(@ModelAttribute("product") Product cat) {

		ModelAndView model = new ModelAndView("productform");
		// returns list of all subcategories from subcategory table.
		List<String> subcategory = subService.getcategoryList();
		// returns list of all categories from category table.
		List<String> category = subService.getallcategory();
		model.addObject("subcategory", subcategory);
		model.addObject("category", category);
		return model;

	}

	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("product") Product cat, BindingResult result) throws Exception {
		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("productform");
			// returns list of all subcategories from subcategory table.
			List<String> subcategory = subService.getcategoryList();
			// returns list of all categories from category table.
			List<String> category = subService.getallcategory();
			model.addObject("subc  ategory", subcategory);
			model.addObject("category", category);
			return model;

		}

		try {
			pService.save(cat);
		} catch (Exception e) {

			String msg = "Invalid data ";
			WarningMsg.showDialog(msg);
		}
		return new ModelAndView("redirect:/product");
	}

	@RequestMapping(value = "/displayProducts/{id}", method = RequestMethod.GET)
	public ModelAndView displayProducts(HttpServletRequest request, HttpServletResponse res, @PathVariable int id,
			HttpSession session) {

		ModelAndView model = new ModelAndView("displayProducts");
		// returns product based on id
		List<Product> sub2 = pService.getProductList(id);
		session = request.getSession(false);
		String username = (String) session.getAttribute("name");
		model.addObject("sub2", sub2);

		model.addObject(username);
		return model;
	}

	/**
	 * 
	 * @param id
	 *            : name of subcategory
	 * @return
	 */

	@RequestMapping(value = "/displayProducts/buynow/{id}", method = RequestMethod.GET)
	public ModelAndView AddToCart(HttpServletRequest request, HttpServletResponse res, @PathVariable String id) {

		ModelAndView model = new ModelAndView("buynow");
		// returns product by subcategory name
		List<Product> sub2 = pService.getbysubname(id);
		model.addObject("sub2", sub2);
		return model;
	}

	@RequestMapping(value = "/displayProducts/buynow/{subcategory}/{ids}", method = RequestMethod.GET)
	public ModelAndView producttobuy(HttpServletRequest request, HttpServletResponse res, @PathVariable int ids,
			@ModelAttribute("order") Order od) {

		ModelAndView model = new ModelAndView("buynow");
		// returns product based on id.
		Product pro = pService.getProductById(ids);
		model.addObject("pro", pro);

		return model;
	}

}
