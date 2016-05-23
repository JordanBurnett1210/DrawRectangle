package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.Controller;

public class Panel extends JPanel
{
	private Controller baseController;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private JButton drawTriangleButton;
	private JButton drawCircleButton;
	private JButton drawEllipseButton;
	private JButton drawSquareButton;
	private JButton drawPolygonButton;
	private JButton clearButton;
	private JButton drawGraph;
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Rectangle> graphList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
		
	private ShapePanel myPanel;
	
	public Panel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		rectangleList = new ArrayList<Rectangle>();
		graphList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
		polygonList = new ArrayList<Polygon>();
		triangleList = new ArrayList<Polygon>();
		
		drawRectangleButton = new JButton("Draw the rectanlge");
		
		drawSquareButton = new JButton("Draw the square");
		
		drawCircleButton = new JButton("Draw the circle");
		
		drawEllipseButton = new JButton("Draw the ellipse");

		drawTriangleButton = new JButton("Draw the triangle");
		
		drawPolygonButton = new JButton("Draw the polygon");
		
		clearButton = new JButton("clear");
		
		drawGraph = new JButton("Draw Graph");
		
		
		myPanel = new ShapePanel();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(clearButton);
		this.add(drawRectangleButton);
		this.add(drawTriangleButton);
		this.add(drawEllipseButton);
		this.add(drawPolygonButton);
		this.add(drawSquareButton);
		this.add(drawCircleButton);
		this.add(drawGraph);
		this.add(myPanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, myPanel, 750, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, myPanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, myPanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, myPanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 70, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawSquareButton, 0, SpringLayout.EAST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawCircleButton, 0, SpringLayout.EAST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawEllipseButton, 0, SpringLayout.EAST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 10, SpringLayout.WEST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawTriangleButton, -6, SpringLayout.NORTH, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 6, SpringLayout.SOUTH, drawEllipseButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawPolygonButton, 0, SpringLayout.EAST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 6, SpringLayout.SOUTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 6, SpringLayout.SOUTH, drawGraph);
		baseLayout.putConstraint(SpringLayout.NORTH, drawGraph, 140, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawCircleButton, -6, SpringLayout.NORTH, drawGraph);
		baseLayout.putConstraint(SpringLayout.EAST, drawGraph, 0, SpringLayout.EAST, drawRectangleButton);
	}
	
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 1500);
				int yPosition = (int)(Math.random() * 500);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 1500);
				int yPosition = (int)(Math.random() * 500);
				int width = (int)(Math.random() * 50);
				int height = width;
				
				squareList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
		drawGraph.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = 0;
				int width = 50;
				for(int i = 0; i < 10; i++)
				{
					int yPosition = 500;
					if(i > 0)
					{
						xPosition += 100;
					}
					int height = (int)(Math.random() * 500);
					yPosition = yPosition-height;
					graphList.add(new Rectangle(xPosition, yPosition, width, height));
					repaint();
				}
			}
		});
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				myPanel.addCircle();
				
				repaint();
			}
		});
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				myPanel.addTriangle();
				
				repaint();
			}
		});
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				myPanel.addEllipse();
				
				repaint();
			}
		});
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				myPanel.addPolygon();
				
				repaint();
			}
		});
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				myPanel.clear();
				
				rectangleList.clear();
				squareList.clear();
				graphList.clear();
				repaint();
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.BLUE);
		mainGraphics.setStroke(new BasicStroke(15));
		mainGraphics.draw(new Rectangle(90,10,20,40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		for(Rectangle current : graphList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		for(Rectangle current : squareList)
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
