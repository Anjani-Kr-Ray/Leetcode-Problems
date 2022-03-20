// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

import java.util.Scanner;

public class SearchInRotatedWithDuplicates {

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
        if(nums.length == 0) 
            return -1;
        
        int start = 0, end = nums.length - 1;
        
        while(start <= end && nums[start] == nums[end]) {
            if(nums[start] == target) 
                return start;
            start++;
            end--;
        }
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) 
                return mid;
            
            if(nums[mid] >= nums[start]) {
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            } 
        }
        
        return -1;
    }

}