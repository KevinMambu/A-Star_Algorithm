import java.util.ArrayList;
public class SortedNodeList
{
	ArrayList<Node> list;
	public SortedNodeList ()
	{
		list = new ArrayList<Node>();
	}

	public void push (Node n)
	{
		list.add (n);
		n.indexNumber = list.size();
	}
	
	public Node pop (Node n)
	{
		Node res = n;
		list.remove (n);
		return res;
	}
}
