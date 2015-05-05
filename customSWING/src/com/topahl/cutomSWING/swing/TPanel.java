package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

import com.topahl.cutomSWING.master.TDimension;
import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TRectangle;
import com.topahl.cutomSWING.master.TScalingEngine;
import com.topahl.cutomSWING.swing.interfaces.TSetBounds;

public class TPanel extends JPanel implements TSetBounds{
	private static final long serialVersionUID = 7576856486712704549L;
	private double autoscalefactor;
	private boolean autoscale;
	private TRectangle bounds;
	
	public TPanel(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
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
}
