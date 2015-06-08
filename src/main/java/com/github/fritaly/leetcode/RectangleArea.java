package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RectangleArea {
	
	private final class Point {
		final int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private final class Rectangle {
		// x1 <= x2, y1 <= y2
		final int x1, x2, y1, y2;
		
		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = Math.min(x1, x2);
			this.y1 = Math.min(y1, y2);
			this.x2 = Math.max(x1, x2);
			this.y2 = Math.max(y1, y2);
		}
		
		public boolean contains(Point p) {
			return (x1 <= p.x) && (p.x <= x2) && (y1 <= p.y) && (p.y <= y2);
		}
		
		public boolean overlap(Rectangle other) {
			for (Point point : other.getPoints()) {
				if (this.contains(point)) {
					return true;
				}
			}
			for (Point point : this.getPoints()) {
				if (other.contains(point)) {
					return true;
				}
			}
			
			return false;
		}
		
		public int surface() {
			return (x2 - x1) * (y2 - y1);
		}
		
		public List<Point> getPoints() {
			return Arrays.asList(new Point(x1, y1), new Point(x1, y2), new Point(x2, y1), new Point(x2, y2));
		}
		
		public Rectangle intersection(Rectangle other) {
			if (!this.overlap(other)) {
				return null;
			}
			
			final List<Integer> xValues = new ArrayList<Integer>(Arrays.asList(this.x1, this.x2, other.x1, other.x2));
			xValues.remove((Object) Math.min(this.x1, other.x1));
			xValues.remove((Object) Math.max(this.x2, other.x2));
			
			final List<Integer> yValues = new ArrayList<Integer>(Arrays.asList(this.y1, this.y2, other.y1, other.y2));
			yValues.remove((Object) Math.min(this.y1, other.y1));
			yValues.remove((Object) Math.max(this.y2, other.y2));
			
			return new Rectangle(Collections.min(xValues),
					Collections.min(yValues), Collections.max(xValues),
					Collections.max(yValues));
		}
	}

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	final Rectangle rectangleABCD = new Rectangle(A, B, C, D);
    	final Rectangle rectangleEFGH = new Rectangle(E, F, G, H);
    	
    	int surface = rectangleABCD.surface() + rectangleEFGH.surface();
    	
    	if (rectangleABCD.overlap(rectangleEFGH)) {
    		surface -= rectangleABCD.intersection(rectangleEFGH).surface();
    	}
    	
    	return surface;
    }
}