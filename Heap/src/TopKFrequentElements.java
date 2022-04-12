// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TopKFrequentElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(Arrays.toString(topKFrequentPQ(nums, k)));
	}
	
	/* Using Only HashMap 
	 * ******************
	 * Time Complexity: O(N log N)
	 * Space Complexity: O(N) */
	public static int[] topKFrequentHM(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }
        
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(m.entrySet());
        System.out.println(sorted);
        
        Collections.sort(sorted, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        
        int[] res = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> e: sorted) {
            if(i!=k) {
                res[i++] = e.getKey();
            }
        }
        
        return res;
    }
	
	/* Using HashMap and PriorityQueue 
	 * *******************************
	 * Time Complexity: less than O(N log N) => O(N log k) 
	 * Space Complexity: O(N + k)
	 * */
	public static int[] topKFrequentPQ(int[] nums, int k) {
        // O(1) time
        if(k==nums.length)
        	return nums;
        
        Map<Integer, Integer> m = new HashMap<>();
        
        // count the frequeny of each distinct element present in nums
        for(int n: nums) {
        	m.put(n, m.getOrDefault(n, 0)+1);
        }
        
        // Create a priority queue with a comparator which stores the least frequent element on top
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)->m.get(n1)-m.get(n2));
        
        for(int n: m.keySet()) {
        	pq.offer(n);
        	if(pq.size() > k) 
        		pq.poll();
        }
        
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
        	res[i] = pq.poll();
        }
        
        return res;
    }
}
