package marchCookOff17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rainbow {

	public static boolean reEvaluate(ArrayList<ArrayList<Integer>> list) {
		for(int i=0;i<list.size();i++) {
			ArrayList<Integer> temp = list.get(i);
			HashMap<Integer,Boolean> map = new HashMap<>();
			int count=0;
			for(int j=0;j<temp.size();j++) {
				if(temp.get(j)!=0) {
					if(!map.containsKey(temp.get(j))) {
						count++;
						map.put(temp.get(j), true);
					}
				}
			}
			if(count<2) {
				list.remove(i);
				for(int k=0;k<list.size();k++) {
					ArrayList<Integer> temp_ = list.get(k);
					temp_.remove(i);
				}
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test=0;test<t;test++) {
			int n = s.nextInt();
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for(int j=0;j<n;j++) {
					temp.add(s.nextInt());
				}
				list.add(temp);
			}
			
			if(n<=2) {
				System.out.println("0");
				continue;
			}
			
			while(true) {
				boolean ans = reEvaluate(list);
				if(list.size()<=2) {
					break;
				}
				if(ans) {
					break;
				} else {
					continue;
				}
			}
			if(list.size()>2) {
				System.out.println(list.size());
			} else {
				System.out.println("0");
			}
		}
	}

}
