// https://leetcode.com/problems/spiral-matrix-ii/

import java.util.Scanner;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = generateMatrix(n);
		
		for(int i[]: arr) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        if (n == 0) {
            return res;
        }
        
        int row = n;
        int col = n;
        
        int rs = 0, cs = 0, re = row - 1, ce = col - 1, k = 1;
        
        while(cs <= ce && rs <= re) {
            for(int i=cs; i<=ce; i++)
                res[rs][i] = k++;
            rs++;

            for(int i=rs; i<=re; i++)
                res[i][ce] = k++;
            ce--;

            if (rs <= re)
                for(int i=ce; i>=cs; i--) 
                    res[re][i] = k++;
            re--;

            if (cs <= ce)
                for(int i=re; i>=rs; i--)
                    res[i][cs] = k++;
            cs++;
        }
        
        return res;
    }
}
