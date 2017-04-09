package marchlunchtime17;

import java.util.Scanner;

public class BearLadder {
	
	public static String connectedOrNot(int a,int b) {
		if(a%2==0) {
			if(a-2==b) {
				return "YES";
			} else if(a+2==b) {
				return "YES";
			} else if(a-1==b) {
				return "YES";
			}
		} else {
			if(a-2==b) {
				return "YES";
			} else if(a+2==b) {
				return "YES";
			} else if(a+1==b) {
				return "YES";
			}
		}
		return "NO";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int t=0;t<test;t++) {
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.println(connectedOrNot(a,b));
		}
	}

}
