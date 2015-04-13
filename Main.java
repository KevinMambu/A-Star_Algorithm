import java.util.ArrayList;

public class Main
{
	public static void main (String[] args)
	{
		World world = new World ();
		SortedNodeList open = new SortedNodeList();
		SortedNodeList closed = new SortedNodeList();
		Node nodeStart = new Node ("o", 3, 3, world);
		world.add (nodeStart);
		Node nodeGoal = new Node ("x", 7, 7, world);
		world.add (nodeGoal);
		Node n;
		Node successor = nodeStart.clone ();
		int F;
		int G;
		int H;
		int F_min;
		int index = 0;
		System.out.println ("main OK");
		while (!successor.isMatch (nodeGoal))
		{
			System.out.println ("while OK");
			F_min = 256;
			for (int i = successor._x - 1; i != successor._x + 2; i += 1)
			{
				for (int j = successor._y - 1; j != successor._y + 2; j += 1)
				{
					n = world.tab[i][j];
					if (successor.compareTo (n) && !open.list.contains (n))
					{
						open.push (n);
						n.parent = successor;
					}
				}
			}

			n = open.pop (successor);
			closed.push (successor);
			for (int i = 0; i != open.list.size(); i += 1)
			{
				n = open.list.get(i);

				H = n.manhattanDistanceTo (nodeGoal);
				G = ((n._x != successor._x) && (n._y != successor._y) ? 14 : 10);
				F = H + G;
				if (F <= F_min)
				{
					index = i;
					F_min = F;
				}
			}
			
			successor = open.list.get(index);
			successor._id = "o";
			world.add (successor);
		
			for (int i = 0; i != world._dx; i += 1)
			{
				for (int j = 0; j != world._dy; j += 1)
				{
					n = world.tab[i][j];
					System.out.print (n._id + " ");
				}
				System.out.println("");
			}
		}
	}
}
