package com.topahl.cutomSWING.swing;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import com.topahl.cutomSWING.master.TManager;

public class TToggleButton extends JToggleButton {
	private static final long serialVersionUID = 1L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TToggleButton(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}
	
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
