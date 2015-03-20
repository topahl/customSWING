package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TRectangle;
import com.topahl.cutomSWING.master.TScalingEngine;

public class TLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2141785246267289701L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TLabel(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height){
		TRectangle a = TScalingEngine.scaleRectangle(new TRectangle(x, y, width, height), autoscale, autoscalefactor);
		super.setBounds(a.getX(),a.getY(),a.getWidth(),a.getHeight());
	}
	
	@Override
	public void setBounds(Rectangle r){
		TRectangle a = TScalingEngine.scaleRectangle(new TRectangle(r), autoscale, autoscalefactor);
		super.setBounds(a.getX(),a.getY(),a.getWidth(),a.getHeight());
	}
		
	/**
	 * After autoscaling the actual size on screen may vary. This method provides the actual size before it was autoscaled.
	 * There might be a variance of 1 from trying to scale into a number that ca be represented in a fixed number of pixels.
	 * @return The size that was set to the object 
	 */
	public Dimension getRealSize(){
			return getRealSize(new Dimension());
	}
	
	/**
	 * After autoscaling the actual size on screen may vary. This method provides the actual size before it was autoscaled.
	 * There might be a variance of 1 from trying to scale into a number that ca be represented in a fixed number of pixels.
	 * @param rv 
	 * @return The size that was set to the object 
	 */
	public Dimension getRealSize(Dimension rv){
		if (!autoscale) {
			return super.getSize(rv);
		} else {
			super.getSize(rv);
			rv.height /= autoscalefactor;
			rv.width /= autoscalefactor;
			return rv;
		}
	}

 	public Rectangle getRealBounds(){
		return getRealBounds(new Rectangle());
	}

	public Rectangle getRealBounds(Rectangle rv){
		if (!autoscale) {
			return super.getBounds(rv);
		} else {
			super.getBounds(rv);
			rv.height /= autoscalefactor;
			rv.width /= autoscalefactor;
			rv.x /= autoscalefactor;
			rv.y /= autoscalefactor;
			return rv;
		}
	}

	
	
	@Override
	public void setIcon(Icon icon){
		super.setIcon(TScalingEngine.scaleImage(icon, autoscale, autoscalefactor, this));
	}
	


	
}
