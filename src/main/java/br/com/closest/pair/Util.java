package br.com.closest.pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {

	public static double distance(Point p1, Point p2) {
		double xdist = Math.abs(p1.x - p2.x);
		double ydist = Math.abs(p1.y - p2.y);
		return Math.sqrt((xdist * xdist) + (ydist * ydist));
	}

	public static void divideInOrder(List<Point> xR,List<Point> xL, List<Point> y,
			List<Point> yR, List<Point> yL) {
		
		for (int i=0;i<xR.size();i++){
			xR.get(i).right = true;
			xR.get(i).left = false;
		}
		
		for (int i=0;i<xL.size();i++){
			xL.get(i).right = false;
			xL.get(i).left = true;
		}
		
		int yLength = y.size();
		for (int i = 0; i < yLength; i++) {
			if (y.get(i).right) {
				yR.add(y.get(i));
			} else {
				yL.add(y.get(i));
			}
		}
	}

	public static void sortByX(List<? extends Point> points) {
		Collections.sort(points, new ByXComparator());
	}

	public static void sortByY(List<? extends Point> points) {
		Collections.sort(points, new ByYComparator());
	}

}
