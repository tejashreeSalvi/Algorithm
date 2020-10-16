package HEAP;
import java.util.*;
public class KSmallestElement {
	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3, 20, 15};
		int k = 3;	
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0 ; i < arr.length; i++){
			queue.add(arr[i]);
			if(queue.size() > k){
				queue.poll();
			}
		}
		System.out.println(queue.peek());
	}
}
