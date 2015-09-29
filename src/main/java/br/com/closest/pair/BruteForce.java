package br.com.closest.pair;

import static br.com.closest.pair.Util.distance;

import java.util.List;

public class BruteForce {

	public static Pair bruteForce(List<? extends Point> points) {
		int numPoints = points.size();
		if (numPoints < 2)
			return null;
		Pair pair = new Pair(points.get(0), points.get(1));
		if (numPoints > 2) {
			for (int i = 0; i < numPoints - 1; i++) {
				Point point1 = points.get(i);
				for (int j = i + 1; j < numPoints; j++) {
					Point point2 = points.get(j);
					double distance = distance(point1, point2);
					if (distance < pair.distance)
						pair.update(point1, point2, distance);
				}
			}
		}
		return pair;
	}

}
