// https://leetcode.com/problems/baseball-game/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] ops = new String[n];
		for(int i=0; i<n; i++) 
			ops[i] = sc.nextLine();
		// System.out.println(Arrays.toString(ops));
		
		System.out.println(calPoints(ops));
	}

	public static int calPoints(String[] ops) {
        int n = ops.length;
        
        int sum = 0;
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(ops[i].equals("C")) {
                s.pop();
            } else if(ops[i].equals("D")) {
                int a = s.peek();
                s.push(a*2);
            } else if(ops[i].equals("+")) {
                int a = s.pop();
                int b = a + s.peek();
                s.push(a);
                s.push(b);
            } else {
                s.push(Integer.parseInt(ops[i]));
            }
        }
        
        for(Integer i: s) {
            sum += i;
        }
        
        return sum;
    }
}
