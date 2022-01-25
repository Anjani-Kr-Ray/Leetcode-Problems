// https://leetcode.com/problems/richest-customer-wealth/

import java.util.Scanner;

public class RichestCustomerWealth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		
		System.out.println(maximumWealth(arr));
	}
	
	public static int maximumWealth(int[][] accounts) {
        int max = -1;
        for(int[] arr: accounts) {
            int sum = 0;
            for(int i: arr) {
                sum += i;
            }
            
            if(max < sum) {
                max = sum;
            }
        }
        
        return max;
    }
}