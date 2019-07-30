package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.visa.prj.entity.DataTransferObject;
import com.visa.prj.entity.Product;

public class ListExample {

	public static void main(String args[]) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"Hp Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
	
		products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));
		
		Stream<Product> mobiles = products.stream().filter(p->{
			System.out.println("DD");
			return p.getCategory().equals("mobile");
		});
		
		mobiles.forEach(p->System.out.println(p)); // If terminal forEach is not added then executing the above line is delayed.
		
		List<String> names = products.stream().map(p -> p.getName()).collect(Collectors.toList());
		for (String string : names) {
			System.out.println(string);
		}
		
		double total = products.stream().map(p->p.getPrice()).reduce(0.0, (v1,v2) -> v1+v2);
		System.out.println(total);
		
		System.out.println("*************");
		products.stream().map(p-> {
			DataTransferObject dtobj = new DataTransferObject(p.getName(), p.getPrice());
			return dtobj;
		}).forEach(p->System.out.println(p));
		
		
//		products.stream().map(p->p.getName()).forEach(System.out::println);
//		Collections.sort(products, (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
//		System.out.println("for each");
//		for (Product product : products) {
//			System.out.println(product);
//		}
		
		
		
		
//		System.out.println("Iterator");
		
//		Iterator<Product> iter = products.iterator();
//		products.add(new Product(33,"",4,"",3)); raises Exception => after iterator is created we cant add new item to the list until iteration should be completed
//		while(iter.hasNext()) {
//			Product p = iter.next();
//			System.out.println(p);
//		}
//		
//		System.out.println("Index based : Avoid");
		
	}
}
