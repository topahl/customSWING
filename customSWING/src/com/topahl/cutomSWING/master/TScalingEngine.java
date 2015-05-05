package com.topahl.cutomSWING.master;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TScalingEngine {

	public static Icon scaleImage(Icon icon,boolean autoscale,double autoscalefactor, Component c){
		if(icon != null && autoscale){
			BufferedImage image = new BufferedImage((int) (icon.getIconWidth()*autoscalefactor),(int)(icon.getIconHeight()*autoscalefactor),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) image.getGraphics();
			AffineTransform affine=new AffineTransform();
			affine.scale(autoscalefactor,autoscalefactor);
			g.setTransform(affine);
			icon.paintIcon(c, g, 0, 0);
			g.dispose();
			return new ImageIcon(image);
		}else{
			return icon;
		}
	}
		
	public static TRectangle scaleRectangle(TRectangle r, boolean autoscale, double autoscalefactor){
		if(!autoscale)
			return r;
		else{
			r.scale(autoscalefactor);
			return r;
		}
	}
	
	public static double scale(double value, boolean autoscale,double autoscalefactor){
		if (!autoscale) {
			return value;
		} else {
			return value*autoscalefactor;
		}
	}
	
	public static Rectangle unscaleRectangle(Rectangle r,boolean autoscale, double autoscalefactor){
		if (!autoscale) {
			return r;
		} else {
			r.height /= autoscalefactor;
			r.width /= autoscalefactor;
			r.x /= autoscalefactor;
			r.y /= autoscalefactor;
			return r;
		}
	}
	
	public static TDimension scaleDimension(TDimension d, boolean autoscale, double autoscalefactor){
		if(!autoscale)
			return d;
		else{
			d.scale(autoscalefactor);
			return d;
		}
		
	}
	
	public static Dimension unscaleDimension(Dimension d, boolean autoscale, double autoscalefactor){
		if (!autoscale) {
			return d;
		} else {
			d.height /= autoscalefactor;
			d.width /= autoscalefactor;
			return d;
		}
	}
}
