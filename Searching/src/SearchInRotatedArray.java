// https://leetcode.com/problems/search-in-rotated-sorted-array/

import java.util.Scanner;
public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		System.out.println("Index of "+t+" : "+search(arr, t));
	}
	
	public static int search(int[] nums, int target) {
        int pivot = -1;
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(mid < end && nums[mid] > nums[mid+1]) 
                pivot = mid;
            
            if(mid > start && nums[mid] < nums[mid - 1])
                pivot = mid - 1;
            
            if(nums[mid] > nums[start])
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        int first_part = binarySearch(nums, target, 0, pivot);
        
        if(first_part != -1)
            return first_part;
        
        return binarySearch(nums, target, pivot+1, nums.length - 1);
    }
    
    public static int binarySearch(int[] arr, int target, int l, int r) {
		
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
