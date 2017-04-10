package aprilChallenge;

import java.util.Scanner;

public class StableMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int t=0;t<test;t++) {
			int n = s.nextInt();
			int q = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			for(int i=0;i<q;i++) {
				int begin = s.nextInt()-1;
				int end = s.nextInt()-1;
				int k = s.nextInt();

				int prev = arr[begin];
				int count = 0;
				int ans = 0;
				for(int j=begin;j<=end;j++) {
					if(j!=begin) {
						if(arr[j]==prev) {
							count++;
							prev = arr[j];
						} else {
							if(count>=k) {
								ans++;
							}
							count=1;
							prev=arr[j];
						}
					} else {
						count++;
					}
					if(j==end) {
						if(count>=k) {
							ans++;
						}
					}
				}
				System.out.println(ans);
			}
		}
	}

}
