package com.hariom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**Paypal : last round : data structure for BT**/
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		super();
		this.data = data;
	}
}

/** impl **/
class BTree{
	Node root;
	Map<Integer, List<Node>> map = new TreeMap<>();
	
	public void levelOrder() {
		Queue<Node> qq = new LinkedList();
		qq.add(root);
		System.out.println("level order :");
		while(!qq.isEmpty()) {
			Node nn = qq.poll();//offer add, poll
			System.out.print(nn.data+" ");
			
			if(nn.left != null) qq.add(nn.left);
			if(nn.right != null) qq.add(nn.right);
			
		}
	}
	
	public void levelOrder2() {
		Queue<Node> qq = new LinkedList<>();
		qq.add(root);
		
		while(!qq.isEmpty()) {
			int levelSize = qq.size();//1
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < levelSize; i++) {
				Node nn = qq.poll();
				list.add(nn.data);
				
				//System.out.print(nn.data+" ");
				if(nn.left != null) qq.add(nn.left);
				if(nn.right != null) qq.add(nn.right);
			}
			System.out.println(list);
			list.clear();
		}
	}
	
}



public class TestClass {
	public static void main(String[] args) {
		BTree tree = new BTree();
		tree.root = new Node(10);
		tree.root.left = new Node(6);
		tree.root.left.left = new Node(68);
		tree.root.left.right = new Node(68);
		tree.root.right = new Node(7);
		tree.root.left.left.left = new Node(69);
		//tree.levelOrder();
		tree.levelOrder2();
		
	}

}
