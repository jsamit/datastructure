package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class Pair<T,V> {
	public T a;
	public V b;
	
	public Pair(T a,V b) {
		this.a = a;
		this.b = b;
	}
}

public class BinTree<T extends Number & Comparable<T>> {
	
	public class Node<T> {
		public T data;
		public Node<T> left;
		public Node<T> right;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> root;
	
	public void insert(T data) {
		if(root == null)
			root = insert(root,data);
		else
			insert(root,data);
	}
	
	public Node<T> insert(Node<T> node,T data) {
		if(node == null) {
			Node<T> temp = new Node<>(data);
			return temp;
		}
		
		if(data.compareTo(node.data) < 0)
			node.left = insert(node.left, data);
		else if(data.compareTo(node.data) > 0) 
			node.right = insert(node.right, data);
		else
			throw new RuntimeException("Duplicate Key exist");
		
		return node;
	}
	
	public void inorder() {
		if(root == null)
			throw new RuntimeException("EmptyTreeException raised");
		inorder(root);
	}
	
	private void inorder(Node<T> node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	
	public void inorderItr() {
		if(root == null)
			throw new RuntimeException("EmptyTreeException raised");
		inorderItr(root);
	}
	
	public void inorderItr(Node<T> node) {
		Stack<Node<T>> st = new Stack<>();
		
		while(node != null || !st.isEmpty()) {
			if(node != null) {
				st.push(node);
				node = node.left;
			} 
			else {
				node = st.pop();
				System.out.println(node.data);
				node = node.right;
			}
		}
	}
	
	public void preOrderItr() {
		if(root == null)
			throw new RuntimeException("EmptyTreeException raised");
		preOrderItr(root);
	}
	
	public void preOrderItr(Node<T> node) {
		Stack<Node<T>> st = new Stack<>();
		
		while(node != null || !st.isEmpty()) {
			if(node != null) {
				System.out.println(node.data);
				st.push(node);
				node = node.left;
			} 
			else {
				node = st.pop();
				node = node.right;
			}
		}
	}
	
	public void postOrderItr() {
		if(root == null)
			throw new RuntimeException("EmptyTreeException raised");
		postOrderItr(root);
	}
	
	public void postOrderItr(Node<T> node) {
		Stack<Node<T>> st = new Stack<>();
		
		while(node != null || !st.isEmpty()) {
			if(node != null) {
				st.push(node);
				node = node.left;
			} 
			else {
				node = st.pop();
				if(node != null) {
					st.push(node);
					st.push(null);
					node = node.right;
				} else {
					node = st.pop();
					System.out.println(node.data);
					node = null;
				}	
			}
		}
	}
	
	public void levelOrder() {
		Node<T> node = root;
		Deque<Node<T>> deque = new ArrayDeque<>();
		
		deque.offerLast(node);
		
		while(!deque.isEmpty()) {
			node = deque.pollFirst();
			System.out.println(node.data);
			
			if(node.left != null)
				deque.offerLast(node.left);
			
			if(node.right != null) 
				deque.offerLast(node.right);
		}
	}
	
	public void verticalOrder() {
		
		Node<T> node = root;
		
		Map<Integer,List<Node<T>>> map = new HashMap<>();
		
		Deque<Pair<Node<T>,Integer>> deque = new ArrayDeque<>();
		
		List<Node<T>> list = new ArrayList<>();
		
		deque.offerFirst(new Pair<>(node,0));
		list.add(node);
		map.put(0, list);
		
		
		while(!deque.isEmpty()) {
			
			Pair<Node<T>,Integer> pair = deque.pollFirst();
			int hd = pair.b;
			node = pair.a;
			
			if(node.left != null) {
				
				deque.offerLast(new Pair<>(node.left,hd-1));
				
				if(map.containsKey(hd-1)) {
					List<Node<T>> list2 = map.get(hd-1);
					list2.add(node.left);
					map.put(hd-1, list2);
				} else {

					List<Node<T>> list1 = new ArrayList<>();
					list1.add(node.left);
					map.put(hd-1, list1);
				}
			}
			if(node.right != null){
				
				deque.offerLast(new Pair<>(node.right,hd+1));
				
				if(map.containsKey(hd+1)) {
					List<Node<T>> list2 = map.get(hd+1);
					list2.add(node.left);
					map.put(hd+1, list2);
				}
				else {
					List<Node<T>> list1 = new ArrayList<>();
					list1.add(node.right);
					map.put(hd+1, list1);
				}
			}
		}
		
		Set<Integer> set = new TreeSet<>(map.keySet());
		
		for(Integer i : set) {
			list = map.get(i);
			for(Node<T> temp: list) {
				System.out.println(temp.data);
			}
		}
		
	}

	public void diagonalOrder() {
		Deque<Node<T>> deque = new ArrayDeque<>();
		Node<T> temp = root;

		deque.offerLast(temp);
		deque.offerLast(new Node<>(null));

		while(!deque.isEmpty()) {
			temp = deque.pollFirst();

			if(temp == null) {
				deque.offerLast(new Node<>(null));
				temp = deque.pollFirst();

				if(temp == null)
					break;
			}

			while(temp != null) {
				if(temp.data != null) System.out.println(temp.data);

				if(temp.left != null)
					deque.offerLast(temp.left);
				temp = temp.right;
			}
		}
	}


	public int height() {
		Deque<Node<T>> deque = new ArrayDeque<>();
		Node<T> temp = root;

		deque.offerLast(temp);
		int height = 0;
		boolean yes = false;

		while(!deque.isEmpty()) {
			temp = deque.pollFirst();

			if(temp.left != null) {
				deque.offerLast(temp.left);
				height++;
				yes = true;
			}
			if(temp.right != null) {
				deque.offerLast(temp.right);
				if(!yes) height++;
				yes = false;
			}
		}

		return height;
	}

	public int noOfLeaf() {
		Deque<Node<T>> deque = new ArrayDeque<>();
		Node<T> temp = root;
		deque.offerLast(temp);
		int count = 0;

		if(root.left == null && root.right == null)
			return 1;

		while(!deque.isEmpty()) {
			temp = deque.pollFirst();

			if(temp.left != null)
				deque.offerLast(temp.left);

			if(temp.right != null)
				deque.offerLast(temp.right);

			if(temp.left == null && temp.right == null)
				count++;
		}

		return count;
	}

	public int noOfTwoDegreeNode() {
		Deque<Node<T>> deque = new ArrayDeque<>();
		Node<T> temp = root;
		deque.offerLast(temp);
		int count = 0;

		while(!deque.isEmpty()) {
			temp = deque.pollFirst();

			if(temp.left != null)
				deque.offerLast(temp.left);

			if(temp.right != null)
				deque.offerLast(temp.right);

			if(temp.left != null && temp.right != null)
				count++;
		}

		return count;
	}

	public int noOfOneDegreeNode() {
		Deque<Node<T>> deque = new ArrayDeque<>();
		Node<T> temp = root;
		deque.offerLast(temp);
		int count = 0;

		while(!deque.isEmpty()) {
			temp = deque.pollFirst();

			if(temp.left != null)
				deque.offerLast(temp.left);

			if(temp.right != null)
				deque.offerLast(temp.right);

			if((temp.left != null && temp.right == null) || (temp.left == null && temp.right != null))
				count++;
		}

		return count;

	}
}
