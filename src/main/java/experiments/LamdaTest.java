package experiments;

import static java.text.MessageFormat.format;

public class LamdaTest {

	public static void main(String[] args) {
		
		// new approach
		Runnable r =() -> System.out.println("hello World"); 
		
		//old approach
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello World"); 
				
			}
		};

	}

}
