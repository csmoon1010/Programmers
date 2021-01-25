package src;
import java.util.Scanner;

public class numberGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		String answer = "";
		
		int start = 0;

	    String target = "";
	    String temp = "";

	    while (target.length() < m * t) {
	        target += Integer.toString(start++, n);
	    }

	    for (int i=0; i<t; i++) {
	        temp += target.charAt(p - 1 + i * m);
	    }

	    answer = temp.toUpperCase();
	    System.out.println(answer);
	}

}
