// https://leetcode.com/problems/matrix-diagonal-sum/

import java.util.Scanner;

public class SquareMatrixDiagonalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(diagonalSum(arr));
		
	}
	
	public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += mat[i][i] + mat[i][n-i-1];
        }
        
        if(n%2 != 0) {
            sum -= mat[n/2][n/2];
        }
        
        return sum;
    }

}
