
public interface DataStructure {
	public <T> T addNode(T root, int value);
	public <T> void removeNode(T root, int value);
	public <T> void traverseNodes(T root);
	public <T> void search(T root, int value);
}
