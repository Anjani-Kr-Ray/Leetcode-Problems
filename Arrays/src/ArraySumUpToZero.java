// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

import java.util.Arrays;
import java.util.Scanner;

public class ArraySumUpToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(Arrays.toString(sumZero(n)));
	}
	
	public static int[] sumZero(int n) {
        int sum = 0; 
        int[] arr = new int[n];
        for(int i=0; i<n-1; i++) {
            arr[i] = i+1;
            sum += arr[i];
        }
        
        arr[n-1] = -sum;
        return arr;
    }

}
