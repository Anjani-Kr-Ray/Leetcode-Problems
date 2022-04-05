// https://leetcode.com/problems/split-array-largest-sum/

import java.util.Scanner;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++)
			nums[i] = sc.nextInt();
		
		int m = sc.nextInt();
		
		System.out.println(splitArray(nums, m));
	}
	
	public static int splitArray(int[] nums, int m) {
		int start = 0, end = 0;
		
		for(int n: nums) {
			start = Math.max(start, n);
			end += n;
		}
		
		// binary search 
		int pieces = 0;
		while(start < end) {
			int mid = start + (end - start) / 2;
			
			int sum = 0;
			for(int num: nums) {
				if(sum + num > mid)
				{
					sum = num;
					pieces++;
				} else {
					sum += num;
				}
				
			}
			
			if(pieces > m) 
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return start;
	}

}
