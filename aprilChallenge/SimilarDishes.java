package aprilChallenge;

import java.util.HashMap;
import java.util.Scanner;

public class SimilarDishes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int t  = s.nextInt();
		for(int test=0;test<t;test++) {
			HashMap<String, Boolean> map = new HashMap<>();
			for(int i=0;i<4;i++) {
				map.put(s.next(),true);
			}
			int count = 0;
			for(int i=0;i<4;i++) {
				if(map.containsKey(s.next())) {
					count++;
				}
			}
			if(count>=2) {
				System.out.println("similar");
			} else {
				System.out.println("dissimilar");
			}
		}
	}

}
