import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// return true if even
		System.out.println(evenOdd(n));
	}
	
	public static boolean evenOdd(int n) {
		return (n & 1) == 0;
	}

}
