// https://leetcode.com/problems/count-items-matching-a-rule/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CountMatchingItems {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.next();
		// TODO Auto-generated method stub
		List<List<String>> l = new ArrayList<List<String>>();
		
		for(int i=0; i<n; i++) {
			List<String> temp = new ArrayList<String>();
			for(int j=0; j<3; j++) {
				temp.add(sc.nextLine());
			}
			l.add(temp);
		}
		
		String ruleKey = sc.nextLine();
		String ruleValue = sc.nextLine();
		
		System.out.println(countMatches(l, ruleKey, ruleValue));
	}
	
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(int i=0; i<items.size(); i++) {
        	System.out.println(items.get(i).get(0));
            if(ruleKey.equals("type") && ruleValue.equals(items.get(i).get(0))) {
                count++;
            }
            
            System.out.println(items.get(i).get(0));
            if(ruleKey.equals("color") && ruleValue.equals(items.get(i).get(1))) {
                count++;
            }
            
            if(ruleKey.equals("name") && ruleValue.equals(items.get(i).get(2))) {
                count++;
            }
        }
        
        return count;
    }

}
