// https://leetcode.com/problems/jump-game/

import java.util.Scanner;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) 
			nums[i] = sc.nextInt();
		
		System.out.println(canJumpBackwardIteration(nums));
	}
	
	/* Method 1: Forward Movement
	 * --------------------------
	 * In this approach we will start with the first element of the array and will move forward by one each 
	 * time. We will define a maxReach variable which would keep track of maximum we can reach from particular
	 * index. If at any point the current index becomes greater than the maxReach, then we can break out of the 
	 * loop because we are at an index which was not within our reach i.e. we cannot reach the last element. 
	 * 
	 * At last, we check whether i==length of the array which signifies that we have reached the end of the array.
	 * */
	
	public static boolean canJumpForwardIteration(int[] nums) {
        int n = nums.length, i = 0;
        int maxReach = 0;
    
        while(i<n && i<=maxReach) {
            int canReach = i + nums[i];
            maxReach = Math.max(canReach, maxReach);
            i++;
        }
        if(i==n)
            return true;
        return false;
    }
    
	/* Method 2: Backward Movement
	 * ---------------------------
	 * In this approach we will start iterating from end of the array and try to move backwards.
	 * If we can successfully reach the first element of the array, it means the result is true i.e.
	 * we can reach the last index of the array.
	 * 
	 * We define the variable lastReach as the last element of the array. At each iteration, we update the
	 * lastReach variable by checking whether the lastReach variable is reachable from that index. 
	 * If yes, the current index becomes the new lastReach. We keep on doing this until we reach the first 
	 * element of the array. 
	 * Now, we check whether lastReach variable is equal to 0 (index of 1st variable) which means we could 
	 * have reached the last element had we started from the first one.
	 * */
    public static boolean canJumpBackwardIteration(int[] nums) {
        int lastReach = nums.length - 1;
        for(int i=nums.length - 2; i>=0; i--) {
            if(i+nums[i] >= lastReach) {
                lastReach = i;
            }
        }
        
        return lastReach == 0;
    }

}
