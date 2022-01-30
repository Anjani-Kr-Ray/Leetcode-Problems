// https://leetcode.com/problems/two-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		int target = sc.nextInt();
		
		System.out.println(Arrays.toString(twoSumList(arr, target)));
		System.out.println(Arrays.toString(twoSumMap(arr, target)));
	}
	
	// Time Complexity: O(nlogn)
	public static int[] twoSumList(int[] nums, int target) {
        List<Integer> l = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            l.add(nums[i]);
        }
        
        Arrays.sort(nums);
        int[] arr = new int[2];
        int i = 0, j = nums.length - 1;
        
        while(i<j) {
            int sum = nums[i] + nums[j];
            if(target == sum) {
                arr[0] = l.indexOf(nums[i]);
                arr[1] = l.lastIndexOf(nums[j]);
                break;
            } else if(target > sum) {
                i++;
            } else {
                j--;
            }
        }
        
        return arr;
    }
	
	public static int[] twoSumMap(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) {
			m.put(nums[i], i);
		}
		
		int l = -1, r = -1;
		
		for(int i=0; i<nums.length; i++) {
			int req = target - nums[i];
			
			if(m.containsKey(req) && m.get(req)!=i)
			{
				l = i;
				r = m.get(req);
				break;
			}
		}
		
		return new int[] {l, r};
	}
}
