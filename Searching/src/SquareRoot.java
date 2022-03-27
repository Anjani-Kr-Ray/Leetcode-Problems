// https://leetcode.com/problems/sqrtx/

import java.util.Scanner;
public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		System.out.println(sqrt3(x));
	}
	
	public static double exactSqrt(int x) {
		double temp, sr = x / 2;
		do {
			temp = sr;
			sr = (temp + ( x / temp)) / 2;
		} while((temp - sr) != 0);
		
		return sr;
	}
	
	public static int sqrt1(int x) {
		if(x==0)
			return 0;
		
		for(int i=1; i<=(x/i); i++) {
			if(i <= (x/i) && (i+1) > (x/(i+1)))
				return i;
		}
		
		return -1;
	}
	
	// The exactSqrt() method and this method is same just it returns the floor of the square root
	public static int sqrt2(int x) {
		if(x==0) 
			return 0;
		
		long i = x;
		
		while(i > x / i) {
			i = (i + (x/i)) / 2;
		}
		
		return (int)i;
	}
	
	public static int sqrt3(int x) {
		if(x==0) 
			return 0;
		
		int start = 1, end = x;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(mid <= x / mid && (mid+1) > x / (mid+1)) {
				return mid;
			} else if(mid > x / mid) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}

}
