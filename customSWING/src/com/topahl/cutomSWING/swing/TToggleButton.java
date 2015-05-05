package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import com.topahl.cutomSWING.master.TDimension;
import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TRectangle;
import com.topahl.cutomSWING.master.TScalingEngine;
import com.topahl.cutomSWING.swing.interfaces.TSetIconExt;

public class TToggleButton extends JToggleButton implements TSetIconExt{
	private static final long serialVersionUID = 1L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	private TRectangle bounds;
	
	public TToggleButton(){
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
	
	@Override
	public void setIcon(Icon icon){
		super.setIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	
	@Override
	public void setRolloverIcon(Icon icon){
		super.setRolloverIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	
	@Override
	public void setSelectedIcon(Icon icon){
		super.setSelectedIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	
	@Override
	public void setPressedIcon(Icon icon){
		super.setPressedIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	
	@Override
	public void setDisabledIcon(Icon icon){
		super.setDisabledIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	@Override
	public void setRolloverSelectedIcon(Icon icon){
		super.setDisabledIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	
}
