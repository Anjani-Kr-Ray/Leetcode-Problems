// https://leetcode.com/problems/guess-number-higher-or-lower/

import java.util.Scanner;

class Guess {
	private static int pick;
	
	public static int guess(int num) {
		if(num > getPick())
			return -1;
		else if(num < getPick())
			return 1;
		else
			return 0;
	}
	
	public static int getPick() {
		return pick;
	}
	public static void setPick(int pick) {
		Guess.pick = pick;
	}
}

public class GuessGame extends Guess{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		setPick(p);
		
		System.out.println(guessNumber(n));
		
		sc.close();
	}

	public static int guessNumber(int n) {
        int start = 0, end = n;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == -1)
                end = mid - 1;
            else if(guess(mid) == 1)
                start = mid + 1;
        }
        
        return -1;
    }
}
