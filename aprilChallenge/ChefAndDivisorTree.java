package aprilChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndDivisorTree {

	static class Node {
		long data;
		ArrayList<Node> children;
		Node parent;
		public Node(long data) {
			this.data = data;
			children = new ArrayList<>();
			parent = null;
		}
	}

	static HashMap<Long, Long> getMax = new HashMap<>();

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
			long child = root.children.get(i).data;
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



	static HashMap<Long, Node> getTree = new HashMap<>();
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
		ArrayList<Long> divisors = getDivisors(n.data);
		for(int i=0;i<divisors.size();i++) {
			Node temp = new Node(divisors.get(i));
			temp.parent=n;
			n.children.add(temp);
			makeTree(temp);
		}
		getTree.put(n.data, n);
	}

	public static long getMaxFromTree(long n) {
		if(getMax.containsKey(n)) {
			return getMax.get(n);
		}
		Node root = new Node(n);
		makeTree(root);
		long max = findMax(root);
		getMax.put(n, max);
		return max;
	}
	
	static HashMap<Long, ArrayList<Long>> divisorsMap = new HashMap<>();
	public static ArrayList<Long> getDivisors(long n) {
		if(divisorsMap.containsKey(n)) {
			return divisorsMap.get(n);
		}
		ArrayList<Long> divisors = new ArrayList<>();
		HashMap<Long, Boolean> map = new HashMap<>();
		for (long i=1; i<=Math.sqrt(n)+1; i++) {
			if (n%i==0) {
				if(i!=n && !map.containsKey(i)) {
					divisors.add(i);
					map.put(i, true);
				}
				if(n/i!=n && !map.containsKey(n/i)) {
					divisors.add(n/i);
					map.put(n/i, true);
				}
			}
		}
		divisorsMap.put(n, divisors);
		return divisors;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long a = s.nextLong();
		long b = s.nextLong();
		long sum = 0;
		for(long i=a;i<=b;i++) {
			sum+=getMaxFromTree(i);
		}
		System.out.println(sum);
		s.close();
	}

}
