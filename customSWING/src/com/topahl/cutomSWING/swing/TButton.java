package com.topahl.cutomSWING.swing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.topahl.cutomSWING.master.TManager;




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
		if(icon != null && autoscale){
			BufferedImage image = new BufferedImage((int) (icon.getIconWidth()*autoscalefactor),(int)(icon.getIconHeight()*autoscalefactor),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) image.getGraphics();
			AffineTransform affine=new AffineTransform();
			affine.scale(autoscalefactor,autoscalefactor);
			g.setTransform(affine);
			icon.paintIcon(this, g, 0, 0);
			g.dispose();
			super.setIcon(new ImageIcon(image));
		}else{
			super.setIcon(icon);
		}
	}
	
}
