package visa.com.prj.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import visa.com.prj.entity.Fruit;

public class FruitClient {

	public static void main(String args[]){
		
		Map<String,Integer> fruits = new HashMap<String,Integer>(); 
		
		fruits.put("Mango",121);
		fruits.put("Apple",60);
		fruits.put("Orange",35);
		
		fruits.put("Pear",1);
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			String extra = sc.nextLine();
			if(fruits.containsKey(extra))
				fruits.put(extra, 1 + fruits.get(extra));
			else
				fruits.put(extra, 1);
			
			fruits.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(System.out::println);
		}
		
		
	}
}
