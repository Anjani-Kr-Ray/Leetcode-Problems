// https://leetcode.com/problems/plus-one/

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(plusOne(arr)));
	}
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits; 
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
