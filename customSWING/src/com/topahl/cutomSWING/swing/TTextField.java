package com.topahl.cutomSWING.swing;

import java.awt.Dimension;

import javax.swing.JTextField;

import com.topahl.cutomSWING.master.TManager;

public class TTextField extends JTextField {
	private static final long serialVersionUID = 3915757349529843764L;
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TTextField(){
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
