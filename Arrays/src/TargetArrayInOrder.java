// https://leetcode.com/problems/create-target-array-in-the-given-order/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetArrayInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] nums = new int[n];
		int[] index = new int[n];
		
		for(int i=0; i<n; i++) 
			nums[i] = sc.nextInt();
		
		for(int i=0; i<n; i++) 
			index[i] = sc.nextInt();
		
		System.out.println(createTargetArray(nums, index));
	}
	
	public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> l = new ArrayList<>();
        int res[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            int in = index[i];
            
            l.add(in, n);
        }
        
        for(int i=0; i<nums.length; i++) {
            res[i] = l.get(i);
        }
        return res;
    }

}
