import java.util.ArrayList;
import java.util.List;


public class Searches {
	public static void main(String[] args){
		Searches s = new Searches();
		Node tree = s.makeTree();
		
		s.BFS(tree, 3);
		s.DFS(tree, 3);
	}
	
	public void BFS(Node root, int value){
		List<Node> queue = new ArrayList<Node>();
		Boolean found=false;
		
		if (null!=root){
			queue.add(root);
		}
		
		while(!found && !queue.isEmpty()){
			Node current = queue.get(0);
			queue.remove(0);
			
			System.out.println("checking node of value "+ String.valueOf(current.value));
			if (current.value != value){
				if (null!=current.left){
					queue.add(current.left);
				}
				if (null!=current.right){
					queue.add(current.right);
				}
			} else {
				System.out.println("found "+String.valueOf(value));
				found = true;
			}
		}
	}
	
	public void DFS(Node root, int value){
		this._doDFS(root, value);
	}
	
	private Boolean _doDFS(Node current, int value){
		if (null==current){
			return false;
		}
		System.out.println("dfs checking "+String.valueOf(current.value));
		if (current.value != value){
			return this._doDFS(current.left, value)
					|| this._doDFS(current.right, value);
		} else {
			System.out.println("dfs found "+String.valueOf(value));
			return true;
		}
	}
	
	private Node makeTree(){
		Node root = new Node(2);
		root.right = new Node(5);
		root.right.right = new Node(12);
		root.left = new Node(23);
		root.left.right = new Node(49);
		root.left.right.left = new Node(3);
		return root;
	}
	
	private class Node{
		public int value;
		public Node left, right;
		
		public Node(int value){
			this.value = value;
		}
	}
}
