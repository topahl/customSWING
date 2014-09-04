package com.topahl.cutomSWING.swing;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.topahl.cutomSWING.master.TManager;

public class TPanel extends JPanel {
	private static final long serialVersionUID = 7576856486712704549L;
	private double autoscalefactor;
	private boolean autoscale;
	
	public TPanel(){
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
