// https://leetcode.com/problems/shuffle-the-array/

import java.util.Arrays;
import java.util.Scanner;

public class ShuffleTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(Arrays.toString(shuffle(arr, (int)(n/2))));
	}
	
	public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        
        int j = 0;
        for(int i=0; i<nums.length; i+=2) {
            ans[i] = nums[j++];
        }
        
        for(int i=1; i<nums.length; i+=2) {
            ans[i] = nums[j++];
        }
        
        return ans;
    }

}
