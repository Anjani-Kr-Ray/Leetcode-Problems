// https://leetcode.com/problems/valid-palindrome-ii/

package com.two_pointers;

import java.util.Scanner;
public class Palindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		System.out.println(validPalidrome(s));
		
	}
	
	public static boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			
			i++;
			j--;
		}
		return true;
	}
	
	public static boolean validPalidrome(String s) {
		int i = 0, j = s.length() - 1;
		
		while(i < j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++; j--;
			} else {
				return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
			}
		}
		
		return true;
	}

}
