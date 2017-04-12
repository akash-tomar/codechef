package aprilChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		for(int test =0;test<t;test++) {
			long l = s.nextLong();
			long r = s.nextLong();
			int[] arr = new int[10];
			for(int i=0;i<10;i++) {
				arr[i]=s.nextInt();
			}
			long count = 0;
			for(long i=l;i<=r;i++) {
				ArrayList<Character> digits = new ArrayList<>();
				HashMap<Character, Integer> map = new HashMap<>();
				String num = i+"";
				for(int j=0;j<num.length();j++) {
					char key = num.charAt(j);
					if(map.containsKey(key)) {
						int val = map.get(key)+1;
						map.put(key, val);
					} else {
						digits.add(key);
						map.put(key, 1);
					}
				}
				boolean flag = false;
				for(int j=0;j<digits.size();j++) {
					if(map.get(digits.get(j))==arr[Integer.parseInt(digits.get(j)+"")]) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
