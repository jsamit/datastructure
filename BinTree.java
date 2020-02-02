package com.tree;

import java.util.Stack;

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
}
