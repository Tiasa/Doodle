/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doodle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tiasa
 */

public class DoodleShape {
    List<Point> points=null;
    Color color;
    int strokeThickness;
    public void addPoint(int x, int y) {
    	if (points == null) {
            setPoints(new ArrayList<Point>());
        }
    	points.add(new Point(x,y));
    }
    public void setPoints(List<Point> points) {
        this.points = points;
    }
    public List<Point> getPoints() {
        return points;
    }
    public Color getColor() {
        return color;
    }
    public int getStrokeThickness() {
        return strokeThickness;
    }
    public void setStrokeThickness(int strokeThickness) {
		this.strokeThickness = strokeThickness;
	}
    public void setColor(Color color) {
		this.color = color;
	}
    public void paint(Graphics2D g2) {
        if (points!=null) {
            int [] x_points = new int[points.size()];
            int [] y_points = new int[points.size()];
            for (int i=0; i < points.size(); i++) {
                x_points[i] = points.get(i).x;
                y_points[i] = points.get(i).y;
            }
        g2.setColor(color);
        g2.setStroke(new BasicStroke(strokeThickness * 4));
        g2.drawPolyline(x_points, y_points, points.size());
        }
    }
}
