// https://leetcode.com/problems/first-bad-version/

import java.util.Scanner;

class VersionControl {
	private static int bad;

	public static int getBad() {
		return bad;
	}

	public static void setBad(int bad) {
		VersionControl.bad = bad;
	}

	public static boolean isBadVersion(int n) {
		if(n == bad)
			return true;
		return false;
	}
}
public class FirstBadVersion extends VersionControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int bad = sc.nextInt();
		
		setBad(bad);

		System.out.println(firstBadVersion(n));
		sc.close();
	}
	
	public static int firstBadVersion(int n) {
		int l = 1,r = n;
	        
	    while(l<=r) {
	    	int mid = l + (r - l) / 2;
	        if(isBadVersion(mid))
	        	r = mid - 1;
	        else
	            l = mid + 1;
	    }
	    return l;
	}

}
