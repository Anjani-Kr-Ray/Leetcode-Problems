// https://leetcode.com/problems/maximum-subarray/

import java.util.Scanner;

public class MaximumSumSubArray {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(maxSubArray(arr));
	}
    // TLE
    public static int maxSubArrayBF(int[] nums) {
        int max_sum = Integer.MIN_VALUE, current_sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                current_sum = 0;
                for(int k=i; k<=j; k++) {
                    current_sum += nums[k];
                }
                if(current_sum > max_sum) {
                    max_sum = current_sum;
                }
            }
        }
        
        return max_sum;
    }
    
    // TLE
    public static int maxSubArrayCS(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        
        int[] cs = new int[nums.length];
        cs[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            cs[i] = cs[i-1] + nums[i];
        }
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                int curr_sum = 0;
                
                if(i!=0)
                    curr_sum = cs[j] - cs[i-1];
                else
                    curr_sum = cs[j];
                
                if(max_sum < curr_sum)
                    max_sum = curr_sum;
            }
        }
        
        return max_sum;
    }
    
    public static int maxSubArray(int[] nums) {
        int cs = 0, ms = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            cs += nums[i];
            if(cs > ms)
                ms = cs;
            if(cs < 0)
                cs = 0;
        }
        
        return ms;
    }
}
