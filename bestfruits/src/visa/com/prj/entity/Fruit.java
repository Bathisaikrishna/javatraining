package visa.com.prj.entity;

import java.util.Comparator;

public class Fruit implements Comparable<Fruit>{

	private int count;
	private String name;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Fruit(String name, int count) {
		this.count = count;
		this.name = name;
	}
	
	@Override
	public int compareTo(Fruit o) {
		return  o.getCount() - this.getCount()  ;
	}
	
}
