package aprilChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BearAndCliqueDistances {

	public static void dijkstras(int source,ArrayList<ArrayList<Integer>> adjacencyList,int n,HashMap<String,Integer> getWeight) {
		HashMap<Integer, Integer> distanceFromSource = new HashMap<>();
		for(int v=1;v<=n;v++) {
			distanceFromSource.put(v, Integer.MAX_VALUE);
		}
		distanceFromSource.put(source, 0);

		ArrayList<Integer> list = new ArrayList<>();
		for(int v=1;v<=n;v++) {
			list.add(v);
		}

		while(list.size()!=0) {
			int minVert=list.get(0);
			for(int v:list) {
				if( distanceFromSource.get(v) < distanceFromSource.get(minVert) ) {
					minVert = v;
				}
			}
			list.remove(Integer.valueOf(minVert));

			ArrayList<Integer> listOfAdjVert = adjacencyList.get(minVert);
			for(int str: listOfAdjVert) {
				int di = distanceFromSource.get(minVert)+getWeight.get(minVert+","+str);
				if(distanceFromSource.get(str) > di) {
					distanceFromSource.put(str,di );
				}
			}
		}
		for(int v=1;v<=n;v++) {
			System.out.print(distanceFromSource.get(v)+" ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		for(int test = 0;test<t;test++) {
			int num_of_cities=s.nextInt();
			int num_of_old_cities =s.nextInt();
			int length_of_road_old_city = s.nextInt();
			int num_of_new_roads =s.nextInt();
			int source = s.nextInt();
			ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
			for(int i=0;i<=num_of_cities;i++) {
				adjacencyList.add(i,new ArrayList<Integer>());
			}
			HashMap<String,Integer> map = new HashMap<>();
			for(int i=0;i<num_of_new_roads;i++) {
				int a=s.nextInt();
				int b = s.nextInt();
				int c = s.nextInt();
				if(!adjacencyList.get(a).contains(b)) {
					adjacencyList.get(a).add(b);
				}
				if(!adjacencyList.get(b).contains(a)) {
					adjacencyList.get(b).add(a);
				}
				map.put(a+","+b,c);
				map.put(b+","+a,c);
			}
			for(int i=1;i<=num_of_old_cities;i++) {
				for(int j=1;j<=num_of_old_cities;j++) {
					if(i!=j) {
						map.put(i+","+j, length_of_road_old_city);
						map.put(j+","+i, length_of_road_old_city);
						if(!adjacencyList.get(i).contains(j)) {
							adjacencyList.get(i).add(j);
						}
						if(!adjacencyList.get(j).contains(i)) {
							adjacencyList.get(j).add(i);
						}
					}
				}
			}
			dijkstras(source, adjacencyList, num_of_cities, map);
		}
	}

}
