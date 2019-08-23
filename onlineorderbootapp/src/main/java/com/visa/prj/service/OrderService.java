package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrders()
	{
		return orderDao.findAll();
	}
	
	@Transactional
	public int placeOrder(Order o)
	{
		orderDao.save(o);
		double total = 0.0;
		List<Item> items = o.getItems();
		for (Item item : items) {
			total += item.getAmount();
			Product p = getById(item.getProduct().getId());
			p.setCount(p.getCount()- item.getQty());
		}
		o.setTotal(total);
		return o.getOid();
	}
	public List<Customer> getCustomers()
	{
		return customerDao.findAll();
	}
	
	
	
	public Customer getCustomerById(String mail)
	{
		return customerDao.findById(mail).get();
	}
	
	@Transactional
	public String saveCustomer(Customer c) {
		customerDao.save(c);
		return c.getEmail();
	}
	
	
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	
	public List<Product> getProductByPrice(double price){
		return productDao.getByPriceGreaterThan(price);
	}
	
	public List<Product> getProductByCategory(String category)
	{
		return productDao.findByCategory(category);
	}
	
	@Transactional
	public int saveProduct(Product p) {
		productDao.save(p);
		return p.getId();
	}
	
	public Product getById(int id)
	{
		return productDao.findById(id).get();
	}
	
	
}
