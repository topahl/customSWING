package com.topahl.cutomSWING.swing;

import java.awt.Font;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.master.TScalingEngine;

public class TFont extends Font{
	private double autoscalefactor = 1;
	private boolean autoscale = false;
	
	public TFont(String name, int style, int size) {
		super(name, style, (int) TScalingEngine.scale(size, TManager.getInstance().isAutoscale(), TManager.getInstance().getAutoScaleFactor()));
		autoscalefactor = TManager.getInstance().getAutoScaleFactor();
		autoscale = TManager.getInstance().isAutoscale();
	}

}
