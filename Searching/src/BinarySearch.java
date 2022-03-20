// qhxmn7ldaep6i3t4ftf4ic6dpb2g7mf7

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		System.out.println("Index of "+t+" : "+binarySearch(arr, t));
	}
	
	public static int binarySearch(int[] arr, int target) {
		int l = 0, r = arr.length - 1;
		
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
