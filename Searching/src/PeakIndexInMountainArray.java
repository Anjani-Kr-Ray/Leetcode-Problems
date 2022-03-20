// https://leetcode.com/problems/peak-index-in-a-mountain-array/

import java.util.Scanner;

public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		System.out.println("Index of peak : "+peakIndexInMountainArray(arr));
	}
	
	public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(arr[mid] < arr[mid+1])
                start = mid + 1;
            else if(arr[mid] > arr[mid+1])
                end = mid;
        }
        
        return start;
    }

}
