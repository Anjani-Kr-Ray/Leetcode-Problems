// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

import java.util.Scanner;

public class PanagramSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(checkIfPangram(s));
	}
	
	public static boolean checkIfPangram(String sentence) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i=0; i<alphabets.length(); i++) {
            if(sentence.indexOf(alphabets.charAt(i)) == -1)
                return false;
        }
        
        return true;
    }

}
