package experiments;

import java.util.WeakHashMap;

public class WeakReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeakHashMap<UniqueImage, BigDataForImage> test = new WeakHashMap<UniqueImage, BigDataForImage>();
		
		UniqueImage un = new UniqueImage();
		BigDataForImage bd = new BigDataForImage();
		
		test.put(un, bd);
		un=null;
//		System.gc();
		
		while(test.size() >0) {
			System.out.println("I came here");
		}
		
		System.out.println("My Program Completed");
	}

}
