import java.util.Scanner;

public class SetIthBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		// return true if even
		System.out.println(setBit(n, i));
	}
	
	public static int setBit(int n, int i) {
		return n | (1 << (i-1));
	}
}
