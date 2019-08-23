package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Customer;
import com.visa.prj.service.OrderService;

@RestController
public class CustomerController {

		@Autowired
		private OrderService orderService;
		
		@GetMapping("customers")
		public @ResponseBody List<Customer> getCustomers()
		{
			return orderService.getCustomers();
		}
		
		@GetMapping("customers/{mail}")
		public @ResponseBody Customer getCustomerById(@PathVariable("mail")String mail) {
			
			return orderService.getCustomerById(mail);
			
		}
		
		@PostMapping("customers")
		public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c) {
			orderService.saveCustomer(c);
			return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
		}
}
