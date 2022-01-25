// https://leetcode.com/problems/build-array-from-permutation/

import java.util.Arrays;
import java.util.Scanner;

public class BuildArrayFromPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(Arrays.toString(buildArray(arr)));
	}
	
	public static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

}
