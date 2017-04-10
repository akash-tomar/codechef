package aprilChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class StableMarket {
	static class Pair {
		int data;
		int freq;
		int begin;
		int end;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int t=0;t<test;t++) {
			int n = s.nextInt();
			int q = s.nextInt();
			ArrayList<Pair> list = new ArrayList<>();
			int prev = -1;
			int prev_index = 0;
			for(int i=0;i<n;i++) {
				int temp = s.nextInt();
				if(prev==-1) {
					Pair p = new Pair();
					p.data=temp;
					p.freq=1;
					p.begin=i;
					p.end=p.begin;
					prev=temp;
					prev_index=0;
					list.add(p);
				} else {
					if(temp==prev) {
						Pair p = list.get(prev_index);
						p.freq++;
						p.end++;
					} else {
						Pair p = new Pair();
						p.data=temp;
						p.begin=i;
						p.end=p.begin;
						p.freq=1;
						prev=temp;
						prev_index++;
						list.add(p);
					}
				}
			}
			for(int j=0;j<q;j++) {
				int begin = s.nextInt()-1;
				int end = s.nextInt()-1;
				int k = s.nextInt();
				int ans = 0;
				int counted_items = 0;
				for(int i=0;i<list.size();i++) {
					Pair p = list.get(i);
					int count=0;
					if(begin <= p.begin) {
						if(end == p.begin) {
							count++;
							counted_items++;
						} else if(end>p.begin && end<p.end ) {
							count+=end-p.begin+1;
							counted_items+=end-p.begin+1;
						} else if(end>=p.end) {
							count+=(p.end-p.begin+1);
							counted_items+=(p.end-p.begin+1);
						}
					} else if(begin>p.begin && begin<p.end ) {
						if(end>p.begin && end<p.end ) {
							count+=(end-begin+1);
							counted_items+=(end-begin+1);
						} else if(end>=p.end) {
							count+=(p.end-begin+1);
							counted_items+=(p.end-begin+1);
						}
					} else if(begin>=p.end) {
						if(end==p.end) {
							count++;
							counted_items++;
						} 
					} 
					if(count>=k) {
						ans++;
					}
					if(counted_items>=end-begin+1) {
						break;
					}
				}
				System.out.println(ans);
			}
		}
	}

}
