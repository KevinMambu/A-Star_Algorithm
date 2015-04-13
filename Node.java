import java.util.ArrayList;

public class Node
{
	String _id;
	int _x;
	int _y;
	int indexNumber;
	Node parent;
	World _world;

	public Node (String id, int x, int y, World w)
	{
		_id = id;
		_x = x;
		_y = y;
		_world = w;
	}

	public boolean compareTo (Node n)
	{
		if (n._id == "#")
		{
			return false;
		}
		return true;
	}

	public boolean isMatch (Node n)
	{
		if ((n._x == _x) && (n._y == _y))
		{
			return true;
		}
		return false;
	}

	public Node clone ()
	{
		Node res = new Node (_id, _x, _y, _world);
		res.parent = parent;
		return res;
	}

	public int manhattanDistanceTo (Node n)
	{
		int res = 0;
		
		int i = _x;
		while (i != n._x + 1)
		{
			if (n._x >= i)
				i += 1;
			else if (n._x <= i)
				i -= 1;
			res += 10;
		}
		
		i = _y;
		while (i != n._y + 1)
		{
			if (n._y >= i)
				i += 1;
			else if (n._y <= i)
				i -= 1;
			res += 10;
		}
		return res;
	}

}
