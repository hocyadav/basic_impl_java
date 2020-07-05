package july5th.bst;

import java.util.LinkedList;
import java.util.Queue;

/**Binary tree data structure**/
class Node{
	int val;
	Node left;
	Node right;
	public Node(int val) {
		super();
		this.val = val;
	}
}

/**Use of Binary tree data structure**/
class BST{
	Node root;
	
	/**DFS traversal - inorder, postorder, preorder**/
	public void inorder() {
		System.out.print("Inorder : ");
		rec_inorder(root);
		System.out.println();
	}

	private void rec_inorder(Node root) {
		if(root == null) return;
		rec_inorder(root.left);
		System.out.print(root.val+" ");
		rec_inorder(root.right);
	}
	
	public void preorder() {
		System.out.print("Preorder : ");
		rec_pre(root);
		System.out.println();
	}

	private void rec_pre(Node root) {
		if(root == null) return;
		System.out.print(root.val+" ");
		rec_pre(root.left);
		rec_pre(root.right);
	}
	
	public void postorder() {
		System.out.print("Postorder : ");
		rec_post(root);
		System.out.println();
	}
	
	private void rec_post(Node root) {
		if(root == null) return;
		rec_post(root.left);
		rec_post(root.right);
		System.out.print(root.val+" ");
	}
	
	/**BFS traversal - level order**/
	public void levelorder() {
		System.out.print("Levelorder BFS : ");
		Queue<Node> qq = new LinkedList();
		qq.add(root);
		
		while(!qq.isEmpty()) {
			Node t = qq.poll();
			System.out.print(t.val+" ");
			
			if (t.left != null) qq.add(t.left);
			if (t.right != null) qq.add(t.right);
		}
		System.out.println();
	}
}

/**Test Binary data structure**/
public class BST_traversal_DFS_BFS {
	public static void main(String[] args) {
		BST obj = new BST();
		obj.inorder();
		obj.preorder();
		obj.postorder();

		obj.root = new Node(10);
		obj.root.left = new Node(1);
		obj.root.right = new Node(20);
		obj.inorder();
		obj.preorder();
		obj.postorder();
		obj.levelorder();
	}
}
