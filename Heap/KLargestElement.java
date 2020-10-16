package HEAP;
import java.util.*;
public class KLargestElement {
	// Print K largest element in heap; 
	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3, 20, 15};
		int k = 3;
		
		PriorityQueue<Integer> minh = new PriorityQueue<Integer>();
		for(int i = 0 ; i < arr.length; i++){
			minh.add(arr[i]);
			if(minh.size() > k){
				minh.poll();
			}
		}
		for(int i = minh.size() ; i > 0; i--){
			System.out.println(minh.peek());
			minh.poll();
		}
	}

}
