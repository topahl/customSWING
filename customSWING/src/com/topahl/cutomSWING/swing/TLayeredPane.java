package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;

import com.topahl.cutomSWING.master.TDimension;
import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TRectangle;
import com.topahl.cutomSWING.master.TScalingEngine;
import com.topahl.cutomSWING.swing.interfaces.TSetBounds;

public class TLayeredPane extends JLayeredPane implements TSetBounds{
	private static final long serialVersionUID = 1450323490100013183L;

	private double autoscalefactor = 1;
	private boolean autoscale = false;
	private TRectangle bounds;
	
	public TLayeredPane(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}
	
	/**
	 * @param autoscale the autoscale to set
	 */
	public void setAutoscale(boolean autoscale) {
		this.autoscale = autoscale;
	}

	@Override
	public Dimension getSize(){
		return bounds.getDimension();
	}
	
	@Override
	public Dimension getSize(Dimension rv){
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
 	public Rectangle getBounds(){
		return bounds.getRectangle();
	}
	
	@Override
	public Rectangle getBounds(Rectangle rv){
		rv.height=bounds.getHeight();
		rv.width=bounds.getWidth();
		rv.x=bounds.getX();
		rv.y=bounds.getY();
		return rv;
	}
}
