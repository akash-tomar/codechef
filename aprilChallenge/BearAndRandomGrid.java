package aprilChallenge;

import java.util.HashMap;
import java.util.Scanner;

public class BearAndRandomGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		for(int test = 0;test<t;test++) {
			int l = s.nextInt();
			int n = s.nextInt();
			String str = s.next();
			char[][] grid = new char[n][n];
			long count_obstacles = 0;
			for(int i=0;i<n;i++) {
				String temp= s.next();
				for(int j=0;j<temp.length();j++) {
					grid[i][j]=temp.charAt(j);
					if(temp.charAt(j)=='#') {
						count_obstacles++;
					}
				}
			}

			if(count_obstacles==0) {
				int ans=-1;
				HashMap<String, Integer> map = new HashMap<>();
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(grid[i][j]=='.') {
							int count = 0;
							int currentX= j;
							int currentY=i;
							for(int k=0;k<str.length();k++) {
								int left = currentX;
								int right = (n-1)-currentX;
								int top = currentY;
								int down = (n-1)-currentY;
								String key = left+","+right+","+top+","+down+","+k;
								if(map.containsKey(key)) {
									count+=map.get(key);
									break;
								} else {
									char move = str.charAt(k);
									if(move=='L') {
										if(currentX-1>=0) {
											if(grid[currentY][currentX-1]=='.') {
												count++;
												currentX--;
											} else {
												break;
											}
										} else {
											break;
										}
									} else if(move=='R') {
										if(currentX+1<n) {
											if(grid[currentY][currentX+1]=='.') {
												count++;
												currentX++;
											} else {
												break;
											}
										} else {
											break;
										}
									} else if(move=='U') {
										if(currentY-1>=0) { 
											if(grid[currentY-1][currentX]=='.') {
												count++;
												currentY--;
											} else {
												break;
											}
										} else {
											break;
										}
									} else if(move=='D') {
										if(currentY+1<n) {
											if(grid[currentY+1][currentX]=='.') {
												count++;
												currentY++;
											} else {	
												break;
											}
										} else {
											break;
										}
									} 
									
								}
							}
							if(ans==-1) {
								ans=count;
							} else {
								ans= ans^count;
							}
						}
					}
				}
			} else {
				int ans=-1;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(grid[i][j]=='.') {
							int count = 0;
							int currentX= j;
							int currentY=i;
							for(int k=0;k<str.length();k++) {
								char move = str.charAt(k);
								if(move=='L') {
									if(currentX-1>=0) {
										if(grid[currentY][currentX-1]=='.') {
											count++;
											currentX--;
										} else {
											break;
										}
									} else {
										break;
									}
								} else if(move=='R') {
									if(currentX+1<n) {
										if(grid[currentY][currentX+1]=='.') {
											count++;
											currentX++;
										} else {
											break;
										}
									} else {
										break;
									}
								} else if(move=='U') {
									if(currentY-1>=0) { 
										if(grid[currentY-1][currentX]=='.') {
											count++;
											currentY--;
										} else {
											break;
										}
									} else {
										break;
									}
								} else if(move=='D') {
									if(currentY+1<n) {
										if(grid[currentY+1][currentX]=='.') {
											count++;
											currentY++;
										} else {	
											break;
										}
									} else {
										break;
									}
								} 
							}
							if(ans==-1) {
								ans=count;
							} else {
								ans= ans^count;
							}
						}
					}
				}
				System.out.println(ans);
			}
		}
	}

}
