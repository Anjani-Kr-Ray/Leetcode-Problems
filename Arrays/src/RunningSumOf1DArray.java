// https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;
import java.util.Scanner;

public class RunningSumOf1DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(Arrays.toString(runningSum(arr)));
	}
	
	public static int[] runningSum(int[] nums) {
		
        for(int i=1; i<nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

}
