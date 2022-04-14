// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

import java.util.Scanner;

public class StepsToReduceToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(numberOfSteps(n));
	}
	
	public static int numberOfSteps(int num) {
        return steps(num, 0);
    }
    
    public static int steps(int num, int count) {
        if(num==0)
            return count;
        
        if(num%2 == 0)
            return steps(num/2, count+1);
        return steps(num-1, count+1);
    }

}
