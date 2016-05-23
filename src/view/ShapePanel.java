package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		
	}
	
	public void clear()
	{
		polygonList.clear();
		triangleList.clear();
		circleList.clear();
		ellipseList.clear();
		
		repaint();
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int[3];
		int [] yPoints = new int[3];
		xPoints[0] = (int)(Math.random() * 250);
		xPoints[1] = (int)(Math.random() * 250);
		xPoints[2] = (int)(Math.random() * 250);
		yPoints[0] = (int)(Math.random() * 250);
		yPoints[1] = (int)(Math.random() * 250);
		yPoints[2] = (int)(Math.random() * 250);
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int diameter = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
		circleList.add(circle);
	}
	
	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 100);
		int height = (int)(Math.random() * 100);
		
		Ellipse2D ellipse = new Ellipse2D.Double(xPoint, yPoint, width, height);
		ellipseList.add(ellipse);
	}
	
	private void drawShapes(Graphics2D mainGraphics, ArrayList<Shape> shapeList)
	{
		for(Shape currentShape : shapeList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int penSize = (int)(Math.random() * 10) + 3;
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.setStroke(new BasicStroke(penSize));
			if(currentShape instanceof Polygon)
			{
				mainGraphics.draw((Shape)currentShape);
			}
			else
			{
				mainGraphics.fill((Shape)currentShape);
			}
		}
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 25) + 3;
		int [] xPoints = new int[numberOfSides];
		int [] yPoints = new int[numberOfSides];
		
		for(int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 300);
			yPoints[sides] = (int)(Math.random() * 300);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Polygon current : triangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		
		for(Polygon current : polygonList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		
		for(Ellipse2D current : circleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		for(Ellipse2D current : ellipseList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		
	}
	
}
