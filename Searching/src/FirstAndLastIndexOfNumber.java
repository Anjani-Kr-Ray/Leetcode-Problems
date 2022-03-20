// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastIndexOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(Arrays.toString(searchRange(arr, t)));

	}
	
    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        return new int[] {leftIndex(nums, target), rightIndex(nums, target)};
        
    }
    
    public static int leftIndex(int[] nums, int target) {
        int start = 0, end = nums.length -1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
            if(target == nums[mid])
                ans = mid;
        }
        
        return ans;
    }
    
    public static int rightIndex(int[] nums, int target) {
        int start = 0, end = nums.length -1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            if(target == nums[mid])
                ans = mid;
        }
        
        return ans;
    }

}
