package view;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Panel;
import controller.Controller;

public class Frame extends JFrame
{	
	private Controller baseController;
	private Panel basePanel;
	
	public Frame(Controller baseController)
	{
		this.baseController = baseController;
		basePanel = new Panel(baseController);
		setupFrame();
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(1500,500);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public Controller getBaseController()
	{
		return baseController;
	}
}
