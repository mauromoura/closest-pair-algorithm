package br.com.closest.pair;

import static br.com.closest.pair.BruteForce.bruteForce;
import static br.com.closest.pair.DivideAndConquer.divideAndConquer;
import static br.com.closest.pair.Util.sortByX;
import static br.com.closest.pair.Util.sortByY;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		for (int i =4 ; i< 30000 ; i+=200){
			calculate(new String [] {String.valueOf(i)});
		}
	}

	public static void calculate(String[] args) {
		int numPoints = (args.length == 0) ? 100000 : Integer.parseInt(args[0]);
		List<Point> points = new ArrayList<Point>();
		Random r = new Random();
		for (int i = 0; i < numPoints; i++)
			points.add(new Point(r.nextDouble(), r.nextDouble()));
		System.out.print(numPoints + ";");
		
		long startTime = System.currentTimeMillis();
		Pair bruteForceClosestPair = bruteForce(points);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.print(elapsedTime + ";");
		
		List<Point> pointsSortedByX = new ArrayList<Point>(points);
		sortByX(pointsSortedByX);
		List<Point> pointsSortedByY = new ArrayList<Point>(points);
		sortByY(pointsSortedByY);
		
		startTime = System.currentTimeMillis();
		Pair dqClosestPair = divideAndConquer(pointsSortedByX, pointsSortedByY);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(elapsedTime);
		
		if (bruteForceClosestPair.distance != dqClosestPair.distance)
			System.out.println("MISMATCH");
	}

}
