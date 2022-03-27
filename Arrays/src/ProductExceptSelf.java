// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Scanner;

public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] nums = new int[n];
		
		for(int i=0; i<nums.length; i++) 
			nums[i] = sc.nextInt();
		
		System.out.println(productExceptSelf(nums));
		sc.close();
	}
	
	// This solution has time complexity of O(n) and space complexity of O(1) provided we ignore the output array
	public static int[] productExceptSelf(int[] nums) {
        int z = 0, p = 1;
        
        for(int i: nums) {
            if(i==0)
                z+=1;
            else
                p *= i; 
        }
        
        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(z==0)
                output[i] = p / nums[i];
            else if(z==1)
                if(nums[i]==0)
                    output[i] = p;
                else
                    output[i] = 0;
            else
                output[i] = 0;
        }
        
        return output;
    }
    
	// This solution has time complexity of O(n) and space complexity of O(1) provided we ignore the output array
    public static int[] productExceptSelfLinearSpace(int[] nums) {
        int n = nums.length; 
        
        int[] left_products = new int[n];
        int[] right_products = new int[n];
        
        int[] output_arr = new int[n];
        left_products[0] = 1;
        right_products[n-1] = 1;
        
        for(int i=1; i<n; i++) {
            left_products[i] = nums[i-1] * left_products[i-1];
        }
        
        for(int i=n-2; i>=0; i--) {
            right_products[i] = nums[i+1] * right_products[i+1];
        }
        
        for(int i=0; i<n; i++) {
            output_arr[i] = left_products[i] * right_products[i];
        }
        
        return output_arr;
    }
    
    // TLE
    // Time complexity O(n^2) and space complexity of O(1) if we ignore 
    public static int[] productExceptSelfBruteForce(int[] nums) {
        
        int[] arr = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            
            int temp = 1;
            for(int j=0; j<nums.length; j++) {
                if(i!=j) {
                    temp *= nums[j];
                }
            }
            arr[i] = temp; 
        }
        
        return arr;
    }

}
