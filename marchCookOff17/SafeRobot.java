package marchCookOff17;

import java.util.Scanner;

public class SafeRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test=0;test<t;test++) {
			int row = s.nextInt();
			int col = s.nextInt();
			String str = s.next();
			int x=0;
			int y=0;
			int minX=0;
			int maxX=0;
			int minY=0;
			int maxY=0;
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch=='L') {
					x--;
					minX = Math.min(minX, x);
				} else if(ch=='R') {
					x++;
					maxX = Math.max(maxX, x);
				} else if(ch=='U') {
					y++;
					maxY = Math.max(maxY, y);
				} else if(ch=='D') {
					y--;
					minY = Math.min(minY, y);
				}
			}
			int rangeX = Math.abs(minX)+maxX;
			int rangeY = Math.abs(minY)+maxY;
			if(rangeX<col && rangeY<row) {
				System.out.println("safe");
			} else {
				System.out.println("unsafe");
			}
		}
	}

}
