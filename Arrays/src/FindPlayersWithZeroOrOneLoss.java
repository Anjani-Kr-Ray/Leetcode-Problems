// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLoss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[][] matches = new int[m][2];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<2; j++) {
				matches[i][j] = sc.nextInt();
			}
		}
		System.out.println(findWinnersBetterWay(matches));
	}
	
	public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> loose = new HashMap<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans0 = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        for(int i=0; i<matches.length; i++) {
            int winner = matches[i][0];
            int looser = matches[i][1];
            
            win.put(winner, win.getOrDefault(winner, 0)+1);
            loose.put(looser, loose.getOrDefault(looser, 0)+1);
        }
        
        
        for(Map.Entry<Integer, Integer> entry: win.entrySet()) {
        	// have not lost any matches
            if(!loose.containsKey(entry.getKey())) {
            	ans0.add(entry.getKey());
            }
        }
        
        
        for(Map.Entry<Integer, Integer> entry: loose.entrySet()) {
        	if(entry.getValue() == 1)
        		ans1.add(entry.getKey());
        }
        
        Collections.sort(ans0);
        Collections.sort(ans1);
        
        ans.add(ans0);
        ans.add(ans1);
        
        return ans;
    }

	public static List<List<Integer>> findWinnersBetterWay(int[][] matches){
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                r.get(losses.get(player)).add(player);
        return r;
    }
}
