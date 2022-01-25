// https://leetcode.com/problems/number-of-good-pairs/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfGoodPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(numIdenticalPairs(arr));
	}
	
	public static int numIdenticalPairsBruteForce(int[] nums) {
	    int sum = 0;
	    
	    for(int i=0; i<nums.length; i++) {
	        for(int j=i+1; j<nums.length; j++) {
	            if(nums[i] == nums[j])
	                sum+=1;
	        }
	    }
	    
	    return sum;
	}

	
	public static int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
				ans = ans + map.get(nums[i]) - 1;
			}
			else {
				map.put(nums[i], 1);
			}
			
		}
		return ans;
	}

}
