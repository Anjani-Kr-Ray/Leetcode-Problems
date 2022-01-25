// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsWithCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		int extraCandies = sc.nextInt();
			
		System.out.println(kidsWithCandies(arr, extraCandies));
	}
	
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        
        List<Boolean> l = new ArrayList<>();
        
        for(int i: candies) {
            if(max < i)
                max = i;
        }
        
        for(int i: candies) {
            if((i+extraCandies) >= max)
                l.add(true);
            else
                l.add(false);
        }
        
        return l;
    } 

}
