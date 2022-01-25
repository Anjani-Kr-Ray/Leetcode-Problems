// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

import java.util.Scanner;

public class NumbersWithEvenNoOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(findNumbersBruteforce(arr));
		System.out.println(findNumbersOptimized(arr));
	}

	public static int findNumbersBruteforce(int[] nums) {
		int count = 0;
		for(int i: nums) {
			count += digits(i); 
		}
		
		return count;
	}
	public static int digits(int n) {
		int d = 0;
		while(n!=0) {
			d += 1;
			n = n / 10;
		}
		
		if(d%2==0)
			return 1;
		
		return 0;
	}
	public static int findNumbersOptimized(int[] nums) {
        int count = 0;
        
        for(int i: nums) {
            int d = (int)Math.log10(i) + 1;
            if(d%2 == 0)
                count++;
        }
        
        return count;
    }
}

