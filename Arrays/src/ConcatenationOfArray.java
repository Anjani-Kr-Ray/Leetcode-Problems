// https://leetcode.com/problems/concatenation-of-array/

import java.util.Arrays;
import java.util.Scanner;

public class ConcatenationOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(Arrays.toString(getConcatenation(arr)));
	}
	
	public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        
        for(int i=0; i<nums.length; i++) {
            ans[i] = nums[i];
            ans[nums.length+i] = nums[i];
        }
        
        return ans;
    }

}
