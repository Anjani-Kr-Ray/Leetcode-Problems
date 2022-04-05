// https://leetcode.com/problems/reverse-string/

package com.two_pointers;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'h','e','l','l','o'};
		reverseString(c);
		System.out.println(Arrays.toString(c));
	}
	
	/* Two Pointers */
	public static void reverseStringTP(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
	
	/* Recursion */
	public static void reverseStringRecursion(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solve(s, i, j);
    }
    public static void solve(char[] s, int i, int j){
        if(i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        solve(s, ++i, --j);
    }
    
    /* Stack */
    public static void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length; i++){
            st.push(s[i]);
        }
        
        int i = 0;
        while(st.size() > 0){
            s[i++] = st.pop();
        }
    }
    

}
