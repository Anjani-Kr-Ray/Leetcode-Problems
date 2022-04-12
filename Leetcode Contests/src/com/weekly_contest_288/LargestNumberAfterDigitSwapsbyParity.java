// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
package com.weekly_contest_288;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LargestNumberAfterDigitSwapsbyParity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(largestIntegerCS(n));
		sc.close();
	}
	
	/* Bruteforce Approach: 
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(1)
	 */
	public static int largestIntegerBF(int num) {
        StringBuilder sb = new StringBuilder(num+"");
        
        for(int i=0; i<sb.length()-1; i++) {
            for(int j=i+1; j<sb.length(); j++) {
                int x = sb.charAt(i)-'0';
                int y = sb.charAt(j)-'0';
                
                if((isEven(x) && isEven(y)) || (isOdd(x) && isOdd(y))) {
                    if(y>x) {
                        char temp = sb.charAt(i);
                        sb.setCharAt(i, sb.charAt(j));
                        sb.setCharAt(j, temp);
                    }
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
	
	private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public static int largestIntegerSorting(int num) {
        ArrayList<Character> even = new ArrayList<>();
        ArrayList<Character> odd = new ArrayList<>();
        
        char[] arr = (num+"").toCharArray();
        ArrayList<Character> p = new ArrayList<>();
        
        for(char ch: arr)
            p.add(ch);
        
        for(char c: p) {
            if((c-'0')%2 == 0)
                even.add(c);
            else
                odd.add(c);
        }
        
        Collections.sort(even,  Collections.reverseOrder());
        Collections.sort(odd,  Collections.reverseOrder());
        
        for(int i=0, j=0, k=0; i<p.size(); i++) {
            char ch = p.get(i);
            p.set(i, (ch-'0')%2==0?even.get(j++):odd.get(k++));
        }
        
        String str = "";
        for(char ch: p)
            str += ch;
        return Integer.parseInt(str);
    }

    // Counting Sort Solution:
    
    public static int largestIntegerCS(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        
        //Calculate the frequency of each digit from 0 - 9
        int[] frequency = new int[10];
        for (int index = 0; index < nums.length; index++) {
            frequency[nums[index] - '0']++;
        }
        
        int newNumber = 0;
        int evenIndex = 8; // corresponds to the number 8 
        int oddIndex = 9; // corresponds to the number 9 

        // construct the number
        for(int index = 0; index < nums.length; index++) {
            // If the parity of number in current index is even
            if(nums[index] % 2 == 0) {
                // Get first even digit of non-zero frequency
                while(frequency[evenIndex]==0) {
                    evenIndex -= 2;
                }
                frequency[evenIndex]--;
                newNumber = newNumber*10 + evenIndex;
            } else {
                // If the parity of number in current index is odd
                // Get first odd digit of non-zero frequency
                while(frequency[oddIndex]==0) {
                    oddIndex -= 2;
                }
                frequency[oddIndex]--;
                newNumber = newNumber*10 + oddIndex;
            }
        }
       
        return newNumber;
    }
    
    // Priority Queue
    public int largestInteger(int num) {
        PriorityQueue<Integer> opq = new PriorityQueue<>();
        PriorityQueue<Integer> epq = new PriorityQueue<>();
        int bnum = num;
        while(num>0){
            int cur = num%10;
            if(cur%2==1){
                opq.add(cur);
            }else{
                epq.add(cur);
            }
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        num = bnum;
        while(num>0){
            int cur = num%10;
            if(cur%2==1)
                sb.insert(0, opq.poll());
            else
                sb.insert(0, epq.poll());
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
