// https://leetcode.com/problems/transpose-matrix/

import java.util.Scanner;

public class TransposeOfAMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		arr = transpose(arr);
		
		for(int[] i: arr) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] transpose(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
    
        int[][] ans = new int[n][m];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans[j][i] = arr[i][j];
            }
        }    
        
        return ans;
    }

}
