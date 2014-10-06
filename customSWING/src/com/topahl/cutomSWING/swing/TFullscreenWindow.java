package com.topahl.cutomSWING.swing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

import com.topahl.cutomSWING.master.TManager;

public class TFullscreenWindow extends JFrame{
	private TLayeredPane gameLayer = new TLayeredPane();
	
	public TFullscreenWindow(){
		super();
		
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
		setResizable(false);
		setUndecorated(true);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(TManager.getInstance().getScreenSize());
		
		//initialize game Layer
		gameLayer.setBounds(
				(TManager.getInstance().getScreenSize().width-TManager.getInstance().getGameSize().width)/2, 
				(TManager.getInstance().getScreenSize().height-TManager.getInstance().getGameSize().height)/2, 
				TManager.getInstance().getGameSize().width, 
				TManager.getInstance().getGameSize().height);
		gameLayer.setBackground(Color.white);
		super.add(gameLayer);
		
		
//		TButton button = new TButton();
//		button.setBounds(0, 0, 100, 100);
//		gameLayer.add(button);
		
		
		
		
		
	}
	@Override
	public Component add(Component comp){
		return gameLayer.add(comp);
	}
	
	public void showWindow(){
		setVisible(true);
	}

}
