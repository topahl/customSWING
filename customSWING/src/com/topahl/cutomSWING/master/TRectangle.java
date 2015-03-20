package com.topahl.cutomSWING.master;

import java.awt.Rectangle;

public class TRectangle {

	private int x,y,height,width;

	public TRectangle(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}

	public TRectangle(Rectangle r){
		this.x=r.x;
		this.y=r.y;
		this.height=r.height;
		this.width=r.width;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

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
	
	public void scale(double scalingfactor){
		x*=scalingfactor;
		y*=scalingfactor;
		width*=scalingfactor;
		height*=scalingfactor;
	}
	
	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
		
	}
}

