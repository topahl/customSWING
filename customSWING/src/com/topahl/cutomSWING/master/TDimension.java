package com.topahl.cutomSWING.master;

import java.awt.Dimension;
import java.awt.Rectangle;


public class TDimension {
	private int height,width;

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	public TDimension(int width, int height){
		this.height=height;
		this.width=width;
	}

	public TDimension(Dimension d){
		this.height=d.height;
		this.width=d.width;
	}
	
	public void scale(double scalingfactor){
		width*=scalingfactor;
		height*=scalingfactor;
	}
	
	public Dimension getDimension(){
		return new Dimension(width, height);
	}
	
	public TDimension clone(){
		return new TDimension(width, height);
	}
}
