// https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MinOperationsToConvertTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String current = sc.nextLine();
		String correct = sc.nextLine();
		
		System.out.println(convertTime(current, correct));
	}

	public static int convertTimeInbuiltMethods(String current, String correct) {
        LocalTime crrct = LocalTime.parse(correct);
        LocalTime crrnt = LocalTime.parse(current);
        
        int count = 0;
        long hours = ChronoUnit.HOURS.between(crrnt, crrct);
        count += hours;
        long mins = ChronoUnit.MINUTES.between(crrnt, crrct) % 60;
        int[] min = {1, 5, 15};
        
        for(int i=min.length - 1; i>=0; i++) {
            while(mins >= min[i]) {
            	mins -= min[i];
            	count++;
            }
        }
        
        return count;
    }
	
	public static int convertTime(String from, String to){
        int diff = minutes(to) - minutes(from), ops[] = {60, 15, 5, 1}, ans = 0;
        for (int op : ops) {
            ans += diff / op;
            diff %= op;
        }
        return ans;
    }

    public static int minutes(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
