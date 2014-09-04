package com.topahl.cutomSWING.swing;

import java.awt.Dimension;

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
}
