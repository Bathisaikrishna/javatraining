import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PoolClient {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2); //create pool of 2 threads
		
		Future<Integer> f1 = service.submit(new Numbers(1,5000)); //future obj hold the returned value by the thread "Numbers"
		Future<Integer> f2 = service.submit(new Numbers(100,500));
		Future<Integer> f3 = service.submit(new Numbers(600,1000));
		Future<Integer> f4 = service.submit(new Numbers(1,50));
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get(100,TimeUnit.SECONDS));
			System.out.println(f3.get());
			System.out.println(f4.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		service.shutdown(); //killing all threads in pool
	}

}
