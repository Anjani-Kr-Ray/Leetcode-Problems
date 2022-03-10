// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

import java.util.Scanner;

public class MinCosToMoveChips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(minCostToMoveChips(arr));
	}

    public static int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        
        for(int i: position) {
            if(i%2 == 0) 
                even++;
            else
                odd++;
        }
        
        if(even==position.length || odd==position.length) {
            return 0;
        }
        
        return Math.min(even, odd);
    }
}
