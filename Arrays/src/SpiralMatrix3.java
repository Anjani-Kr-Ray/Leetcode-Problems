//https://leetcode.com/problems/spiral-matrix-iii/

import java.util.Scanner;

public class SpiralMatrix3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int rs = sc.nextInt();
		int cs = sc.nextInt();
		
		int[][] matrix = spiralMatrix(m, n, rs, cs);
		
		for(int i[]: matrix) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] spiralMatrix(int rows, int cols, int r0, int c0) {
		int[][] matrix = new int[rows*cols][2];
		
		int[] directions = new int[] {0, 1, 0, -1, 0};
		int len = 0;
		int d = 0;
		int i = 0;
		matrix[i++] = new int[]{r0, c0};
		
		while(i < rows * cols) {
			if(d==0 || d==2) {
				len++;
			}
			
			for(int k=0; k<len; k++) {
				r0 += directions[d];
				c0 += directions[d+1];
			}
			
			d = ++d % 4;
		}
		
		return matrix;
	}
}
