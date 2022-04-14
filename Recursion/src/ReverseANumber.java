
public class ReverseANumber {
	private static int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12048;
		reverse1(n);
		System.out.println(sum);
		System.out.println(reverse2(n));
	}
	
	public static void reverse1(int n) {
		if(n==0)
			return;
		
		sum = sum * 10 + (n%10);
		reverse1(n/10);
	}
	
	public static int reverse2(int n) {
		if(n==0)
			return 0;
		int digits = (int) (Math.log10(n));
		
		return (n%10) * (int)(Math.pow(10, digits)) + reverse2(n/10);
	}
	
	

}
