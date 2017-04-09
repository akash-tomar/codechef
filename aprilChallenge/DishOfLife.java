package aprilChallenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class DishOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		for(int test=0;test<t;test++) {
			int n = s.nextInt();
			int k = s.nextInt();
			ArrayList<ArrayList<Integer>> islands = new ArrayList<>();
			for(int i=0;i<n;i++) {
				int dummy = s.nextInt();
				ArrayList<Integer> temp = new ArrayList<>();
				for(int j=0;j<dummy;j++) {
					int ingredient = s.nextInt();
					temp.add(ingredient);
				}
				islands.add(temp);
			}
			
			islands.sort(Comparator.comparing(ArrayList::size));
			HashMap<Integer, Boolean> map = new HashMap<>();
			int count = 0;
			boolean done  = false;
			for(int i=islands.size()-1;i>=0;i--) {
				ArrayList<Integer> temp = islands.get(i);
				for(int j =0;j<temp.size();j++) {
					if(!map.containsKey(temp.get(j))) {
						count++;
						map.put(temp.get(j), true);
					}
					if(count==k && i>0) {
						System.out.println("some");
						done= true;
						break;
					} else if(count==k && i==0) {
						System.out.println("all");
						done=true;
						break;
					}
				}
				if(done) {
					break;
				}
			}
			if(done) {
				continue;
			} else {
				System.out.println("sad");
			}
		}
	}

}
