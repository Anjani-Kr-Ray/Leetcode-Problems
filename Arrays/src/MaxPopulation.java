// https://leetcode.com/problems/maximum-population-year/

import java.util.Scanner;

public class MaxPopulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(maximumPopulation(arr));
	}

	public static int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        
        for(int[] log: logs) {
            for(int j=log[0]; j<log[1]; j++) {
                arr[j - 1950]++;
            }
        }
        
        int count = 0;
        int year = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > count) {
                count = arr[i];
                year = 1950 + i; 
            }
        }
        
        return year;
    }
}
