package com.visa.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class CartController {

	@Autowired
	private OrderService os;
	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req) {
		String[] prds = req.getParameterValues("prds");
		List<Item> items = new ArrayList<>();
		for (String pid : prds) {
			Product p = os.getById(Integer.parseInt(pid));
			Item item = new Item();
			item.setProduct(p);
			item.setQty(1);
			item.setAmount(p.getPrice()*item.getQty());
			
			items.add(item);
		}
		
		Order o1 = new Order();
		o1.setItems(items);
		HttpSession ses = req.getSession();
		Customer c = new Customer();
		c.setEmail(ses.getAttribute("user").toString());
		o1.setCustomer(c);
		os.placeOrder(o1);
		return "index.jsp";
	}
}
