// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

import java.util.Scanner;

public class NextGreatestLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		char a[]=new char[n];

		for(int i=0;i<n;i++){
			a[i]=sc.next().charAt(0); //takes the first character of the string.
		}
		char t = sc.next().charAt(0);
		System.out.println(nextGreatestLetter(a, t));
	}
	public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target < letters[mid])
            	end = mid - 1;
            else
                start = mid + 1;
                
        }
        return (letters[start % letters.length]);
    }

}
