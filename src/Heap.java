import java.util.ArrayList;
import java.util.List;


public class Heap{ // implements DataStructure {

	private List<Integer> space = new ArrayList<Integer>();
	private int last;
	
	public Heap(int value){
		this.space.add(0, -999);
		this.space.add(1, value);
		this.last = 2;
	}
	
	public Heap addNode(int value) {
		this.space.add(this.last, value);
		int current = this.last;		
		this.last++;
				
		while ((int) Math.floor(current/2) > 0 && this.space.get(current) > this.space.get((int) Math.floor(current/2))) {
			int tmp = this.space.get(current);
			this.space.remove(current);
			this.space.add(current, this.space.get((int)Math.floor(current/2)));
			this.space.remove((int)Math.floor(current/2));
			this.space.add((int)Math.floor(current/2), tmp);
			current = (int)Math.floor(current/2);
		}

		for (int i: this.space){
			System.out.print(i+" ");
		}
		System.out.println(" ");
		return this;
	}

	public Boolean removeNode(int value) {
		int current = this.space.indexOf(value);
		if (-1==current){
			return false;
		}
				
		this.space.set(current, this.space.get(--this.last));
		this.space.remove(this.last);
				
		int last = this.last-1;				
		int leftval = last>=current*2? this.space.get(current*2):Integer.MIN_VALUE;
		int rightval = last>=current*2+1? this.space.get(current*2+1):Integer.MIN_VALUE;
		int currentval = this.space.get(current);
		
		while (currentval < rightval || currentval < leftval){
			if (rightval>leftval){ //swap with right
				this.space.set(current, rightval);
				this.space.set(current*2+1, currentval);
				current = current*2+1;
			} else {
				this.space.set(current, leftval);
				this.space.set(current*2, currentval);
				current = current*2;
			}
			
			leftval = last>=current*2? this.space.get(current*2):Integer.MIN_VALUE;
			rightval = last>=current*2+1? this.space.get(current*2+1):Integer.MIN_VALUE;
			currentval = this.space.get(current);			
		}
		
		for (int i: this.space){
			System.out.print(i+" ");
		}
		System.out.println(" ");		
		
		return true;
	}
	
	public void traverseNodes() {
	}

	public void search(int value) {
	}
		
//	public class Node {
//		public int value;
//		public Node parent;
//		public Node left, right;
//		public Node(Node parent, int value){
//			this.value = value;
//			this.parent = parent;
//			this.left = null;
//			this.right = null;
//		}
//	}
	
	public static void main(String[] args){
		Heap h = new Heap(123);
		h.addNode(3).addNode(25).addNode(35)
			.addNode(-4).addNode(788).addNode(1)
			.addNode(98).addNode(40);
		
		h.removeNode(788);
		h.removeNode(123);
	}
}
