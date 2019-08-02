import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSample {
 public static void main(String args[]) {
	List<Integer> iList = Arrays.asList(5,43,234,32,221);
	List<String> sList = Arrays.asList("Hi","AA","bB");
	
	print(iList);
	print(sList);
	
	List<Integer> idList = new ArrayList<>();
	List<String> sdList = new ArrayList<>();
	
	copy(idList,iList);
	copy(sdList,sList);
	
	
	}
 

 
// '? ' -> unknown type but allows only accessors but it doesnt allow mutation on objects
private static void print(List<?> list) {
	for (Object object : list) {
		System.out.println(object);
	}
	list.get(0); //valid
	// list.add(new Object(3));   Not valid
	}


//allows mutation
private static <T> void copy(List<T> dest, List<T> src) {
	for (T elem : src) {
		dest.add(elem);
	}
}

 
}
