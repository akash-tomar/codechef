package aprilChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndDivisorTree {

	static class Node {
		int data;
		ArrayList<Node> children;
		Node parent;
		public Node(int data) {
			this.data = data;
			children = new ArrayList<>();
			parent = null;
		}
	}

	static HashMap<Integer, Long> getMax = new HashMap<>();

	static class Pair {
		long nodeDegree;
		long treeMax;
		boolean parent;
	}
	
	public static long findMax(Node root) {
		if(getMax.containsKey(root.data)) {
			if(root.parent!=null) {
				return getMax.get(root.data)+1;
			} else {
				return getMax.get(root.data);
			}
		}
		if(root.children.size()==0) {
			if(root.parent!=null) {
				return 1;
			} else {
				return 0;
			}
		}
		long ans  = root.children.size();
		if(root.parent!=null) {
			ans+=1;
		} 
		long max = Integer.MIN_VALUE;
		for(int i=0;i<root.children.size();i++) {
			int child = root.children.get(i).data;
			long lol = findMax(root.children.get(i));
			max  = Math.max(lol,max);
		}
		if(max!=Integer.MIN_VALUE) {
			ans+=max;
		}
		if(root.parent!=null) {
			getMax.put(root.data, ans-1);
		} else {
			getMax.put(root.data, ans);
		}
		return ans;
	}

	
	
	static HashMap<Integer, Node> getTree = new HashMap<>();
	public static void makeTree(Node n) {
		if(getTree.containsKey(n.data)) {
			Node temp = getTree.get(n.data);
			temp.parent=n.parent;
			n=temp;
			return;
		}
		if(n.data==1) {
			return;
		}
		ArrayList<Integer> divisors = getDivisors(n.data);
		for(int i=0;i<divisors.size();i++) {
			Node temp = new Node(divisors.get(i));
			temp.parent=n;
			n.children.add(temp);
			makeTree(temp);
		}
		getTree.put(n.data, n);
	}

	public static long getMaxFromTree(int n) {
		if(getMax.containsKey(n)) {
			return getMax.get(n);
		}
		Node root = new Node(n);
		makeTree(root);
		long max = findMax(root);
		getMax.put(n, max);
		return max;
	}
	static HashMap<Integer, ArrayList<Integer>> divisorsMap = new HashMap<>();
	public static ArrayList<Integer> getDivisors(int n) {
		if(divisorsMap.containsKey(n)) {
			return divisorsMap.get(n);
		}
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i=1; i<=Math.sqrt(n)+1; i++) {
			if (n%i==0) {
				// If divisors are equal, print only one
				if (n/i == i) {
					if(i!=n && !divisors.contains(i)) {
						divisors.add(i);
					}
				}

				else {
					if(i!=n && !divisors.contains(i)) {
						divisors.add(i);
					}
					if(n/i!=n && !divisors.contains(n/i)) {
						divisors.add(n/i);
					}
				}
			}
		}
		divisorsMap.put(n, divisors);
		return divisors;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> temp = getDivisors(12);
		int a = s.nextInt();
		int b = s.nextInt();
		long sum = 0;
		for(int i=a;i<=b;i++) {
			sum+=getMaxFromTree(i);
		}
		System.out.println(sum);
	}

}
