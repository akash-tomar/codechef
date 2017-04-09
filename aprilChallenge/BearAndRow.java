package aprilChallenge;

import java.util.Scanner;

public class BearAndRow {

	static class Pair {
		int time;
		int last_one;
		public Pair() {
			time = 0;
			last_one=-1;
		}
	}

	public static Pair getMaxTime(int[] arr,int begin) {
		int time = 0;
		int count  = 0;
		int index = begin+1;
		int nextBegin = -1;
		if(arr[begin]==1) {
			if(begin==arr.length-1) {
				nextBegin=begin;
			} else {
				while(true) {
					if(index==arr.length) {
						arr[index-1]=1;
						arr[begin]=0;
						time+=count;
						count=0;
						nextBegin=index-1;
						break;
					}
					if(arr[index]==0) {
						count++;
						index++;
					} else {
						if(begin!=index-1) {
							arr[index-1]=1;
							arr[begin]=0;
							time+=count;
							time++;
							count=0;
							nextBegin=index;

						} else {
							nextBegin=begin+1;
						}
						break;
					}
				}
			}
		} else {
			nextBegin=begin+1;
		}
		if(nextBegin!=begin) {
			Pair nextBeginAns = getMaxTime(arr, nextBegin);
			while(true) {
				if(arr[nextBeginAns.last_one-1]==1) {
					nextBeginAns.last_one--;
				} else {
					break;
				}
			}
			if(begin!=0) {
				if(arr[begin]!=0) {
					int currentOne = begin-1;
					int nextOne = nextBeginAns.last_one;
					arr[nextOne-1]=1;
					arr[currentOne]=0;
					time+=( (nextOne-1)-currentOne +1);
					Pair p = new Pair();
					p.time=time;
					p.last_one=nextOne-1;
					return p;
				} else {
					return nextBeginAns;
				}
			} else {
				if(arr[begin]==0) {
					nextBeginAns.time+=time;
					return nextBeginAns;
				} else {
					arr[begin]=0;
					arr[nextBeginAns.last_one-1]=1;
					time+=((nextBeginAns.last_one-1)-begin +1);
					Pair p = new Pair();
					p.time=time;
					p.last_one=nextBeginAns.last_one-1;
					return p;
				}
			}
		} else {
			Pair p = new Pair();
			p.time = 0;
			p.last_one = begin;
			return p;
		}
	}

	public static int getLoopTime(int[] arr) {
		int time = 0;

		while(true) {
			int i = getFirstDecentIndex(arr);
			if(i==-1) {
				break;
			}
			time++;
			int count  = 0;
			int index = i+1;
			while(true) {
				if(index==arr.length) {
					arr[index-1]=1;
					arr[i]=0;
					time+=count;
					count=0;
					break;
				}
				if(arr[index]==0) {
					count++;
					index++;
				} else {
					arr[index-1]=1;
					arr[i]=0;
					time+=count;
					count=0;
					break;
				}
			}
		}
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		for(int test = 0;test<t;test++) {
			String str = s.next();
			int[] arr = new int[str.length()];
			for(int i=0;i<str.length();i++) {
				arr[i]=Integer.parseInt(str.charAt(i)+"");
			}

			Pair p = getMaxTime(arr, 0);
			System.out.println(p.time);

		}
	}
	public static int getFirstDecentIndex(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				if(i+1<arr.length) {
					if(arr[i+1]==0) {
						return i;
					}
				}
			}
		}
		return -1;
	}
}
