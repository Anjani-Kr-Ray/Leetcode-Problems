// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.Scanner;

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		//setMatrixZeroBruteForce(arr);
		setMatrixZeroLinearSpace(arr);
		
		for(int i[]: arr) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	/*
	 *  This bruteforce solution will only work if 0 < matrix[i][j] < 2^31 because we're using -1 as value for 
	 *  all the elements in its(where 0 is present) row and column to -1, except when an element is 0
	 */
	
	
	public static void setMatrixZeroBruteForce(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(arr[i][j] == 0) {
					for(int k=0; k<cols; k++)
						if(arr[i][k]!=0)
							arr[i][k] = -1;
					
					for(int k=0; k<rows; k++)
						if(arr[k][j]!=0)
							arr[k][j] = -1;
				}
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(arr[i][j] == -1)
					arr[i][j] = 0;
			}
		}
	}
	
	public static void setMatrixZeroLinearSpace(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		boolean[] r = new boolean[rows];
		boolean[] c = new boolean[cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(arr[i][j] == 0) {
					r[i] = true;
					c[j] = true;
				}
			}
		}
		
		for(int i=0; i<r.length; i++) {
			if(r[i])
				for(int j=0; j<cols; j++) {
					arr[i][j] = 0;
				}
		}
		
		for(int i=0; i<c.length; i++) {
			if(c[i])
				for(int j=0; j<rows; j++) {
					arr[j][i] = 0;
				}
		}
	}
	
	public static void setMatrixZeroInPlace(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		boolean rflag = false;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(arr[i][j] == 0) {
					if(i==0) {
						rflag = true;
						break;
					} else {
						arr[0][j] = 0;
						arr[i][0] = 0;
					}
				}
			}
		}
		
		for(int i=1; i<rows; i++)
			for(int j=1; j<cols; j++)
				if(arr[0][j] == 0 || arr[i][0] == 0)
					arr[i][j] = 0;
		
		if(arr[0][0] == 0)
			for(int i=0; i<rows; i++)
				arr[i][0] = 0;
		
		if(rflag)
			for(int i=0; i<cols; i++)
				arr[0][i] = 0;
	}
}