// https://leetcode.com/problems/find-the-highest-altitude/

import java.util.Scanner;

public class HighestAltitude {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(largestAltitude(arr));
	}

	public static int largestAltitude(int[] gain) {
        int max =0, sum =0 ;
        for(int i=0;i< gain.length;i++){
            
            sum += gain[i];
            max = sum > max ? sum :max ;
            
        }
        return max;
    }
}
