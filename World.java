import java.util.ArrayList;

public class World
{
	int _dx;
	int _dy;
	Node[][] tab;

	public World()
	{
		_dx = 10;
		_dy = 10;
		tab = new Node[_dx][_dy];
		for (int i = 0; i != _dx; i += 1)
		{
			for (int j = 0; j != _dy; j += 1)
			{
				tab[i][j] = new Node (".", i, j, this);
			}
		}

		for (int j = 1; j != _dy; j += 1)
		{
			(tab[4][j])._id = "#";
		}

	}

	public void add (Node n)
	{
		tab[n._x][n._y] = n;
		return;
	}

}
