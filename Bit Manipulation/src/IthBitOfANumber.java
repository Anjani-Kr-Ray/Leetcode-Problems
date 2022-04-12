import java.util.Scanner;

public class IthBitOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		// return true if even
		System.out.println(bit(n, i));
	}
	
	public static int bit(int n, int i) {
		return (n & (1 << (i-1))) >> (i-1);
	}
} 