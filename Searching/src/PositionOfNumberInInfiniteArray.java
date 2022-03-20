// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

import java.util.Scanner;

public class PositionOfNumberInInfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		System.out.println("Index of "+t+" : "+position(arr, t));
	}

	public static int position(int[] arr, int target) {
		int start = 0, end = 1;
		
		while(arr[end] <= target) {
			int newStart = end + 1;
			end = end + (end - start + 1) * 2;
			start = newStart;
		}
		
		return binarySearch(arr, target, start, end);
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		int l = start, r = end;
		
		while(l<=r) {
			int mid = l + (r - l) / 2;
			
			if(arr[mid] == target)
				return mid;
			if(arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		
		return -1;
	}
}
