package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JProgressBar;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TRectangle;
import com.topahl.cutomSWING.master.TScalingEngine;
import com.topahl.cutomSWING.swing.interfaces.TSetBounds;

public class TProgressBar extends JProgressBar implements TSetBounds{
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	private boolean smooth = true;
	private TRectangle bounds;
	Animator updater;
	
	
	public TProgressBar(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
		updater = new Animator(this);
	}
	
	public void setSmooth(boolean value){
		smooth=value;
	}
	
	@Override
	public void setValue(int n){
		if(smooth){
			updater.setValue(n);
		}
		else{
			setValueDirect(n);
		}
	}
	public void setValueDirect(int n){
		super.setValue(n);
	}
	
	@Override
	public Dimension getRealSize(){
		return bounds.getDimension();
	}
	
	@Override
	public Dimension getRealSize(Dimension rv){
		return bounds.getDimension(rv);
	}
	
	@Override
	public void setSize(int width, int height){
		if(bounds == null){
			bounds = new TRectangle(0, 0, width, height);
		}
		else{
			bounds.setHeight(height);
			bounds.setWidth(width);
		}
		setBounds();
	}
	
	@Override
	public void setSize(Dimension d){
		if(bounds == null){
			bounds = new TRectangle(0, 0, d.width, d.height);
		}
		else{
			bounds.setHeight(d.height);
			bounds.setWidth(d.width);
		}
		setBounds();
	}
	
	private void setBounds(){
		TRectangle a  =TScalingEngine.scaleRectangle(bounds.clone(), autoscale, autoscalefactor);
		super.setBounds(a.getX(),a.getY(),a.getWidth(),a.getHeight());
	}
	@Override
	public void setBounds(int x, int y, int width, int height){
		bounds = new TRectangle(x, y, width, height); 
		TRectangle a  =TScalingEngine.scaleRectangle(bounds.clone(), autoscale, autoscalefactor);
		super.setBounds(a.getX(),a.getY(),a.getWidth(),a.getHeight());
	}
	@Override
	public void setBounds(Rectangle r){
		bounds = new TRectangle(r);
		TRectangle a = TScalingEngine.scaleRectangle(bounds.clone(), autoscale, autoscalefactor);
		super.setBounds(a.getX(),a.getY(),a.getWidth(),a.getHeight());
	}
	
	
	
	@Override
 	public Rectangle getRealBounds(){
		return bounds.getRectangle();
	}
	
	@Override
	public Rectangle getRealBounds(Rectangle rv){
		rv.height=bounds.getHeight();
		rv.width=bounds.getWidth();
		rv.x=bounds.getX();
		rv.y=bounds.getY();
		return rv;
	}
	
	private class Animator extends Thread{
		private int current = 0; 
		private int goal = 0;
		public int sleep = 20;
		private TProgressBar bar;
	
		public Animator(TProgressBar bar){
			this.bar = bar;
			this.start();
		}
		
		public void run(){
			try {
				while(true){
					if(current>goal)
						current--;
					if(current<goal)
						current++;
					bar.setValueDirect(current);
						sleep(sleep);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void setValue(int n){
			if(this.isAlive())
				goal = n;
			else
				bar.setValueDirect(n);
		}
		
	}
	
}
