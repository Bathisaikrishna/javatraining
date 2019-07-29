package com.visa.prj.client;

import java.lang.reflect.Method;
import java.util.Iterator;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {
public static void main(String args[])
{
	Product[] products = new Product[5]; //array of pointer but not array of objects
	products[0] = new Tv(133,"Sony Bravia", 135000,"LED");
	products[1] = new Mobile(453,"MotoG",12999.00,"4G");
	products[2] = new Tv(634,"Onida Thunder", 3500.00, "CRT");
	products[3] = new Mobile(621,"iPhone XR", 99999.00, "4G");
	products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
	
	printExpensive(products);
	printInfo(products);
	printInfoOCP(products);
}


		
	
		
	private static void printInfoOCP(Product[] products) {
	for (Product product : products) {
		Method[] methods = product.getClass().getMethods();
		for (Method m : methods) {
			if(m.getName().startsWith("get")){
					try {
						Object ret = m.invoke(product);
						System.out.println(ret);
					} catch (Exception e) {
						System.out.println(e);
					}
		}
	
		}
    }
}





	private static void printInfo(Product[] products) {//need to be changed in future when new product comes 
	for (Product product : products) {
		System.out.println(product.getName() + "," + product.getPrice());
		
		if(product.getClass() == Tv.class) { //strict checking
			Tv t = (Tv) product;
			System.out.println(t.getConnectivity());
		}
		else if(product instanceof Mobile) { //checking whether product belong to class
			Mobile m = (Mobile) product;
			System.out.println(m.getConnectivity());
		}
	}
	
}





	
	


private static void printExpensive(Product[] products) {
	for (int i = 0; i < products.length; i++) {
		if(products[i].isExpensive())
			System.out.println(products[i].getName() + " is expensive!");
		else
			System.out.println(products[i].getName() + " is not expensive!");
	}
	
}
}
