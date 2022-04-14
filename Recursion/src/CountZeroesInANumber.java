
public class CountZeroesInANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10001000;
		
		System.out.println(count(n));
	}
	
	public static int count(int n) {
		return helper(n, 0); 
	}
	
	private static int helper(int n, int c) {
		if(n==0)
			return c;
		
		if(n%10 == 0)
			c += 1;
		
		return helper(n/10, c);
		
	}

}
