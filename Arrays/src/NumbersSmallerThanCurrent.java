// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class NumbersSmallerThanCurrent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = nums.clone();
        int[] res = new int[nums.length];
        
        Arrays.sort(arr);
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int i=0; i<arr.length; i++) {
            if(!m.containsKey(arr[i]))
                m.put(arr[i], i);
        }
        
        for(int i=0; i<nums.length; i++) {
            res[i] = m.get(nums[i]);
        }
        
        return res;
    }

}
