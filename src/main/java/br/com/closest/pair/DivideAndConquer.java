package br.com.closest.pair;

import static br.com.closest.pair.BruteForce.bruteForce;
import static br.com.closest.pair.Util.distance;
import static br.com.closest.pair.Util.divideInOrder;

import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {

	public static Pair divideAndConquer(List<Point> pointsSortedByX,
			List<Point> pointsSortedByY) {
		int numPoints = pointsSortedByX.size();
		if (numPoints <= 3)
			return bruteForce(pointsSortedByX);

		int dividingIndex = numPoints >>> 1;

		List<Point> leftOfCenterX = pointsSortedByX.subList(0, dividingIndex);
		List<Point> rightOfCenterX = pointsSortedByX.subList(dividingIndex,
				numPoints);

		List<Point> leftOfCenterY = new ArrayList<Point>();
		List<Point> rightOfCenterY = new ArrayList<Point>();

		divideInOrder(rightOfCenterX, pointsSortedByY, rightOfCenterY,
				leftOfCenterY);

		Pair closestPair = divideAndConquer(leftOfCenterX, leftOfCenterY);
		Pair closestPairRight = divideAndConquer(rightOfCenterX, rightOfCenterY);

		if (closestPairRight.distance < closestPair.distance)
			closestPair = closestPairRight;

		ArrayList<Point> tempList = new ArrayList<Point>();

		double shortestDistance = closestPair.distance;
		double centerX = rightOfCenterX.get(0).x;
		for (Point point : pointsSortedByY)
			if (Math.abs(centerX - point.x) < shortestDistance)
				tempList.add(point);

		for (int i = 0; i < tempList.size() - 1; i++) {
			Point point1 = tempList.get(i);
			for (int j = i + 1; j < tempList.size()
					&& tempList.get(j).y - point1.y < shortestDistance; j++) {
				Point point2 = tempList.get(j);
				double distance = distance(point1, point2);
				if (distance < closestPair.distance) {
					closestPair.update(point1, point2, distance);
					shortestDistance = distance;
				}
			}
		}
		return closestPair;
	}

}
