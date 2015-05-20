package com.topahl.cutomSWING.test;

import java.awt.Color;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TButton;
import com.topahl.cutomSWING.swing.TFullscreenWindow;
import com.topahl.cutomSWING.swing.TProgressBar;

public class Test {

	public static void main(String[] args) {
		
		TManager.getInstance().setScaleReference(TManager.SCALE_SQUARE);
		TFullscreenWindow window = new TFullscreenWindow();
		TProgressBar label = new TProgressBar();
		label.setBounds(500, 500, 200, 50);
		window.add(label);
		window.showWindow();
		label.setValue(10);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.RED);
	}

}
