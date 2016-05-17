package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private ArrayList<Rectangle> graphList;
	
	public Panel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		rectangleList = new ArrayList<Rectangle>();
		graphList = new ArrayList<Rectangle>();
		
		drawRectangleButton = new JButton("Draw the rectanlge");
		drawSquareButton = new JButton("Draw the square");
		drawCircleButton = new JButton("Draw the circle");
		drawEllipseButton = new JButton("Draw the ellipse");
		drawTriangleButton = new JButton("Draw the triangle");
		drawPolygonButton = new JButton("Draw the polygon");
		clearButton = new JButton("clear");
		drawGraph = new JButton("Draw Graph");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.add(clearButton);
		this.add(drawRectangleButton);
		this.add(drawTriangleButton);
		this.add(drawEllipseButton);
		this.add(drawPolygonButton);
		this.add(drawSquareButton);
		this.add(drawCircleButton);
		this.add(drawGraph);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 600);
				int yPosition = (int)(Math.random() * 600);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
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
	}
}
