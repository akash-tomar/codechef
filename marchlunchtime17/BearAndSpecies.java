package marchlunchtime17;

import java.util.Scanner;

public class BearAndSpecies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		for(int test = 0;test<t;test++) {
			int n= s.nextInt();
			char[][] arr = new char[n][n];
			for(int i=0;i<n;i++) {
				String str = s.nextLine();
				for(int j =0;j<n;j++) {
					arr[i][j]=str.charAt(j);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					char ch = arr[i][j];
					
				}
			}
		}
	}
	public static int waysToFillCurrentBlock(char[][] arr,int x,int y) {
		if(x > arr.length && y>arr.length) {
			return 0;
		}
		int ans = 0;
		char way1_ = getSomething(arr, x-1, y);
		char way2_ = getSomething(arr, x+1, y);
		char way3_ = getSomething(arr, x, y-1);
		char way4_ = getSomething(arr, x, y+1);
		int way1=0;
		int way2=0;
		int way3=0;
		int way4=0;
				
		if(way1_=='?') {
			way1 += waysToFillCurrentBlock(arr, x-1, y);
		} else if(way1_=='.') {
			way1+=3;
		} else {
			way1+=1;
		}
		
		if(way2_=='?') {
			way2 += waysToFillCurrentBlock(arr, x+1, y);
		} else if(way2_=='.') {
			way2+=3;
		} else {
			way2+=1;
		}
		
		if(way3_=='?') {
			way3 += waysToFillCurrentBlock(arr, x, y-1);
		} else if(way3_=='.') {
			way3+=3;
		} else {
			way3+=1;
		}
		
		if(way4_=='?') {
			way4 += waysToFillCurrentBlock(arr, x, y+1);
		} else if(way4_=='.') {
			way4+=3;
		} else {
			way4+=1;
		}
		
		return Math.min(way1, Math.min(way2, Math.min(way3, way4)));
		
	}
	public static char getSomething(char[][] arr,int x,int y) {
		if(arr[x][y]=='B') {
			return 'B';
		} else if(arr[x][y]=='P') {
			return 'P';
		} else if(arr[x][y]=='G') {
			return '.';
		} else if(arr[x][y]=='.') {
			return '*';
		} else if(arr[x][y]=='?') {
			return '?';
		}
		return ' ';
	}

}
