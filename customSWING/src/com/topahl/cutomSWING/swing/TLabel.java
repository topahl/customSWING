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

public class TLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3270570305403830090L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TLabel(){
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}
	
	@Override
	public void setSize(int width, int height) {
		if(!autoscale)
			super.setSize(width, height);
		else{
			super.setSize((int)(width*autoscalefactor), (int)(height*autoscalefactor));
		}
		
	}
	
	@Override
	public void setSize(Dimension d){
		setSize(d.width, d.height);	
	}

	
	@Override
	public void setBounds(int x, int y, int width, int height){
		if(!autoscale)
			super.setBounds(x, y, width, height);
		else{
			super.setBounds((int)(x*autoscalefactor), (int)(y*autoscalefactor), (int)(width*autoscalefactor), (int)(height*autoscalefactor));
		}
	}

	public void setBounds(Rectangle r){
		setBounds(r.x, r.y, r.width, r.height);
	}
	
	public Dimension getRealSize(){
			return getSize(new Dimension());
	}
	
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
		return getBounds(new Rectangle());
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
