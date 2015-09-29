package br.com.closest.pair;

import java.util.Comparator;

public class ByXComparator implements Comparator<Point> {
	public int compare(Point point1, Point point2) {
		if (point1.x < point2.x)
			return -1;
		if (point1.x > point2.x)
			return 1;
		return 0;
	}
}
