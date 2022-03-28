// https://leetcode.com/problems/rotate-array/

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) 
			nums[i] = sc.nextInt();
		int k = sc.nextInt();
		
		/* Time Complexity : O(n*k)
		 * Space Complexity : O(1) */
		// bubbleRotate(nums, k);
		
		/* Time Complexity : O(n)
		 * Space Complexity : O(1) */
		jugglingRotate(nums, k);
		
		/* Time Complexity : O(n)
		 * Space Complexity : O(n) */ 
		// rotateUsingIntermediateArray
		
		/* Time Complexity : O(n)
		 * Space Complexity: O(1) */
		// reversal(nums, k);
		System.out.println(Arrays.toString(nums));
		sc.close();
	}
	
	/* Method 1: Bubble Rotate ( A brute force approach)
	 * -------------------------------------------------
	 * In this solution we are moving the last element to first and while doing so we are shifting each
	 * elements towards right (except last element which is moved towards left. This is similar to bubble sort
	 * 
	 * First Iteration is shown below : 
	 * 
	 * 		nums = [1,2,3,4,5,6],  k = 2
	 * 
	 * 		i = 0, j = 5, nums = [1,2,3,4,6,5]
	 * 		i = 0, j = 4, nums = [1,2,3,6,4,5]
	 * 		i = 0, j = 3, nums = [1,2,6,3,4,5]
	 * 		i = 0, j = 2, nums = [1,6,2,3,4,5]
	 * 		i = 0, j = 1, nums = [6,1,2,3,4,5] */
	public static void bubbleRotate(int[] nums, int k) {
		int n = nums.length;
		
		k %= n;
		
		for(int i=0; i<k; i++) {
			for(int j=n-1; j>0; j++) {
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
			}
		}
	}
	
	/* Method 2: Juggling Algorithm
	 * ----------------------------
	 * This is extension of method 1. Instead of moving elements one by one we will divide array into different
	 * sets where number of sets is equal to gcd of n (length of array) and k(number of times array will get 
	 * rotated) and then move elements within sets. When gcd(n,k) = 1,then elements will be moved within 
	 * one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store 
	 * temp at the right place.
	 * */
	
	public static int gcd(int a, int b) {
		if(b==0) 
			return a;
		return gcd(b, a%b);
	}
	public static void jugglingRotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		
		int sets = gcd(n, k);
		int d = -1;
		for(int i=0; i<sets; i++) {
			int j = n - 1 - i;
			int temp = nums[j];
			
			while(true) {
				d = (((j - k) % n) + n)%n;
				if(d==(n-1-i))
					break;
				nums[j] = nums[d];
				j = d;
			}
			
			nums[j] = temp;
		}
	}
	
	/* Method 3: Intermediate Array
	 * ----------------------------
	 * This is a straight forward solution where we take an extra array and then store last k element at the
	 * beginning of temporary array and then copy the remaining elements from the array.
	 * As we have to update the original array we can use in-built java function System.arraycopy to copy 
	 * temporary array to original
	 * 
	 * For example: nums = [1,2,3,4,5,6] k = 2
	 * 
	 * result = [0,0,0,0,0,0]
	 * i. First copy last k elements to result
	 * 		result = [5,6,0,0,0,0]
	 * ii. Now copy remaining (n-k) elements from start
	 * 		result = [5,6,1,2,3,4]
	 * */
	public static void rotateUsingIntermediateArray(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		
		int[] result = new int[n];
		
		for(int i=0; i<k; i++) {
			result[i] = nums[n-k+i];
		}
		
		int j = 0;
		
		for(int i=k; i<n; i++) {
			result[i] = nums[j++];
		}
		
		System.arraycopy(result, 0, nums, 0, n);
	}
	
	/* Method 4: Rotate using swaps
	 * -----------------------------
	 * In this technique we first reverse the whole array. Then we reverse first k elements and then remaining
	 * (n-k) elements. 
	 * 
	 * For example: Let us take k = 3 and nums = [1,2,3,4,5,6]
	 * 
	 * i. Reverse whole array : 
	 * 	  	nums = [6,5,4,3,2,1]
	 * ii. Now reverse first k elements (here k = 3)
	 * 		nums = [4,5,6,3,2,1]
	 * iii. Now reverse the remaining (n-k) elements
	 * 		nums = [4,5,6,1,2,3] --> rotated array.*/
	public static void reverse(int[] nums, int i, int j) {
		while(i<=j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++; j--;
		}
	}
	public static void reversal(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
	}
	
	
}
