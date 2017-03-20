package Practice;

import java.util.Scanner;

public class Players {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++) {
			int n=s.nextInt();
			double ans=0;
			for(int j=1;j<=n;j++) {
				ans+=1.0/j;
			}
			System.out.println(n*ans);
		}
	}

}
