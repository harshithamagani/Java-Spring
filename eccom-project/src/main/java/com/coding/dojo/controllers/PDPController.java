package com.coding.dojo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.dojo.models.Category;
import com.coding.dojo.models.Order;
import com.coding.dojo.models.OrderProduct;
import com.coding.dojo.models.Product;
import com.coding.dojo.models.User;
import com.coding.dojo.services.CategoryService;
import com.coding.dojo.services.OrderProductService;
import com.coding.dojo.services.OrderService;
import com.coding.dojo.services.ProductService;
import com.coding.dojo.services.UserService;

@Controller
@RequestMapping("/lotus")
public class PDPController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	private final UserService userService;
	private final OrderProductService orderProductService;
	private final OrderService orderService;
	
	public PDPController(OrderService orderService,ProductService productService,CategoryService categoryService,UserService userService,OrderProductService orderProductService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.userService = userService;
		this.orderProductService = orderProductService;
		this.orderService = orderService;
	}
	
	@RequestMapping("/products/{id}")
	public String displayProductDetails(@PathVariable("id")Long id,Model model,HttpSession session) {
		boolean userInSession;
		List<Category> categories = categoryService.findAllCategories();
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		if(session.getAttribute("user")==null) {
			userInSession = false;
		}
		else {
			userInSession = true;
		}
		model.addAttribute("userInSession", userInSession);
		return "productDetailsPage.jsp";
	}
	
	@RequestMapping(value="/new/order/product", method = RequestMethod.POST)
	public String addToCart(HttpSession session,HttpServletRequest request) {
		Order order;
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) session.getAttribute("user");
    	User user = userService.findUserById(user_id);
    	List<Order> orders = user.getOrders();
		if(session.getAttribute("order") == null) {
			order = new Order();
   		 	orderService.createOrder(order);
   		 	if(orders.size() > 0){
   		 		orders.set(0, order);
   		 	}
   		 	else {
   		 		orders.add(order);
   		 	}
   		 	user.setOrders(orders);
   		 	userService.save(user);
   		 	session.setAttribute("order", order.getId());
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
    	Long id = Long.parseLong(request.getParameter("product"));
    	Product product = productService.findProductById(id);
    	OrderProduct orderProduct = new OrderProduct(order, product, quantity);
    	orderProductService.createOrderProduct(orderProduct);
    	List<OrderProduct> orderProducts = order.getOrderProducts();
    	if(orderProducts != null) {
    		orderProducts.add(orderProduct);
    	}
    	else {
    		orderProducts = new ArrayList<>();
    		orderProducts.add(orderProduct);
    	}
    	order.setOrderProducts(orderProducts);
    	if(orders.size() > 0){
		 		orders.set(0, order);
		 	}
		 	else {
		 		orders.add(order);
		 	}
    	orderService.createOrder(order);
    	user.setOrders(orders);
		userService.save(user);
		}
		else {
			Long order_id = (Long) session.getAttribute("order");
			Order orderSession =  orderService.findOrderById(order_id);
			int quantity=Integer.parseInt(request.getParameter("quantity"));
	    	Long id = Long.parseLong(request.getParameter("product"));
	    	Product product = productService.findProductById(id);
	    	OrderProduct orderProduct = new OrderProduct(orderSession, product, quantity);
	    	orderSession.getOrderProducts().add(orderProduct);
	    	orderService.createOrder(orderSession);
		}
		return "redirect:/lotus/cart";
	}
	
	
	@RequestMapping("/cart")
	public String showCartPage(HttpSession session,Model model) {
		if(session.getAttribute("user") != null) {
			Long user_id =  (Long) session.getAttribute("user");
			User user = userService.findUserById(user_id);
			if(session.getAttribute("order")!= null) {
				Long order_id = (Long) session.getAttribute("order");
				Order order =  orderService.findOrderById(order_id);
				List<Category> categories = categoryService.findAllCategories();
				model.addAttribute("categories", categories);
				System.out.println("cartpage"+order.getOrderProducts().toString());
				model.addAttribute("order", order);
			}
		}
		return "cartPage.jsp";
	}
	
	@RequestMapping("/order")
	public String displayOrderPage() {
		return "orderPage.jsp";
	}
	
	
	
	
}
