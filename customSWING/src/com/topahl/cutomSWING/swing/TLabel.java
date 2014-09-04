package com.topahl.cutomSWING.swing;

import java.awt.Dimension;

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
	public void setSize(Dimension d) {
		if(!autoscale)
			super.setSize(d);
		else{
			d.setSize(d.getWidth()*autoscalefactor, d.getHeight()*autoscalefactor);
			super.setSize(d);
		}
	}
}
