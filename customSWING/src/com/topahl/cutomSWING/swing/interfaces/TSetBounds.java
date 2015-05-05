package com.topahl.cutomSWING.swing.interfaces;

import java.awt.Dimension;
import java.awt.Rectangle;

public interface TSetBounds {
	
	public void setBounds(int x, int y, int width, int height);
	
	public void setBounds(Rectangle r);
	
	public Rectangle getRealBounds();
	
	public Rectangle getRealBounds(Rectangle rv);
	
	public void setSize(int width, int height);
	
	public void setSize(Dimension d);
	
	public Dimension getRealSize();
	
	public Dimension getRealSize(Dimension d);

}
