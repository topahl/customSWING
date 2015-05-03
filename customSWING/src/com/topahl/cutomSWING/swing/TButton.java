package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TScalingEngine;




public class TButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3471497407345816213L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TButton(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}
	
	@Override
	public void setSize(Dimension d) {
		if(!autoscale)
			super.setSize(d);
		else{
			d.setSize(d.getWidth()*autoscalefactor, d.getHeight()*autoscalefactor);
			super.setSize(d);
		}
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height){
		if(!autoscale)
			super.setBounds(x, y, width, height);
		else{
			super.setBounds((int)(x*autoscalefactor), (int)(y*autoscalefactor), (int)(width*autoscalefactor), (int)(height*autoscalefactor));
		}
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
	
}
