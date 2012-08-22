import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TreeSerializer{

	public TreeSerializer(){
		
	}
	
	public static void main(String[] args){
		TreeSerializer t = new TreeSerializer();
		Node root = t.getNode();
		root.setValue(10);
		
		t.serializer(root);
	}
	
	private class Node{
		private int _value;
		private Node _left, _right;
		public Node() {}
		public int getValue(){ return this._value; }
		public void setValue(int value){ this._value = value; } 
		public Node getLeft(){ return this._left; }
		public void setLeft(Node value){ this._left = value; } 
		public Node getRight(){ return this._right; }
		public void setRight(Node value){ this._right = value; } 
	}
	
	public Node getNode(){
		return new Node();
	}
	
	public String serializer(Node root){
	    Map<Integer, String> out = new HashMap<Integer, String>();
	    this._serializer(out, root, 1);
	    
	    String output = "";
	    Set<Integer> keys = out.keySet();
	    for(int i : keys){
	        output += i+":"+out.get(i)+"|";
	    }
	    
	    return output.substring(0, output.length()-1);
	}    
	
	public Node deserializer(String instr){
	    String[] nodestr = instr.split("|");    
	    Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	    
	    for(int i=0, total=nodestr.length; i<total; i++){
	        String[] s = nodestr[i].split(":");
	        Node n = new Node();
	        n.setValue(Integer.parseInt(s[1]));
	        nodes.put(Integer.parseInt(s[0]), n);    
	    }
	    
	    if (nodes.get(1) == null){
	        return null;
	    }        
	    Node root = nodes.get(1);
	    
	    this._deserializer(nodes, root, 1);
	    return root;
	}
	
	
	private void _deserializer(Map<Integer, Node> nodes, Node root, int idx){
	    if (root == null){
	        return;
	    }
	    
	    if (nodes.get(idx*2) != null){ //left exists
	        root.setLeft( nodes.get(idx*2) );
	        this._deserializer(nodes, root.getLeft(), idx*2);
	    }
	    if (nodes.get(idx*2+1) != null){ //right exists
	        root.setRight( nodes.get(idx*2+1) );
	        this._deserializer(nodes, root.getRight(), idx*2+1);        
	    }
	}
	
	
	private void _serializer(Map<Integer, String> out, Node root, int idx){       
	    if (root == null){
	        return;
	    }
	    
	    out.put(idx, Integer.toString(root.getValue()) );
	    
	    if (root.getLeft() != null){
	        this._serializer(out, root.getLeft(), idx*2);
	    } 
	    if (root.getRight() != null){
	        this._serializer(out, root.getRight(), idx*2+1);
	    } 
	} 

	//--------------original in the interview--------------
//	public String serializer(Node root){
//	    Map<Integer, String> out = new HashMap<Integer, String>();
//	    this._serializer(out, root, 1);
//	    
//	    String output = "";
//	    Set keys = out.keySet();
//	    for(int i in keys){
//	        output += i+":"+out.get(i)+"|";
//	    }
//	    
//	    return output.substring(0, output.length-1);
//	}    
//
//	public Node deserializer(String instr){
//	    String[] nodestr = instr.split("|");    
//	    Map<Integer, Node> nodes = new HashMap<Integer, Node>();
//	    
//	    for(int i=0, total=nodestr.length; i<total; i++){
//	        String[] s = nodestr[i].split(":");
//	        Node n = new Node()
//	        n.setValue(s[1]);
//	        nodes.put(Integer.parseInt(s[0]), n);    
//	    }
//	    
//	    if (nodes.get(1) == null){
//	        return null;
//	    }        
//	    Node root = nodes.get(1);
//	    
//	    this._deserializer(node, root, 1);
//	    return root;
//	}
//
//
//	private void _deserializer(Map<Integer, String> nodes, Node root, int idx){
//	    if (root == null){
//	        return;
//	    }
//	    
//	    if (nodes.get(idx*2) != null){ //left exists
//	        root.setLeft( nodes.get(idx*2) );
//	        this._deserializer(nodes, root.getLeft(), idx*2);
//	    }
//	    if (nodes.get(idx*2+1) != null){ //right exists
//	        root.setRight( nodes.get(idx*2+1) );
//	        this._deserializer(nodes, root.getRight(), idx*2+1);        
//	    }
//	}
//
//
//	private void _serializer(Map<Integer, String> out, Node root, int idx){       
//	    if (root == null){
//	        return;
//	    }
//	    
//	    out.put(idx, root.getValue().toString() );
//	    
//	    if (root.getLeft() != null){
//	        this._serializer(out, root.getLeft(), idx*2);
//	    } 
//	    if (root.getRight() != null){
//	        this._serializer(out, root.getRight(), idx*2+1);
//	    } 
//	}    
	
	
	
	
}