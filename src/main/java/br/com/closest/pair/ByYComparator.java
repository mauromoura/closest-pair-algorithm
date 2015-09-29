package br.com.closest.pair;

import java.util.Comparator;

public class ByYComparator implements Comparator<Point> {
	public int compare(Point point1, Point point2) {
		if (point1.y < point2.y)
			return -1;
		if (point1.y > point2.y)
			return 1;
		return 0;
	}
}
