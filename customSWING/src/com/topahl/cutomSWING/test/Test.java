package com.topahl.cutomSWING.test;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TButton;
import com.topahl.cutomSWING.swing.TFullscreenWindow;

public class Test {

	public static void main(String[] args) {
		
		TManager.getInstance().setScaleReference(TManager.SCALE_SQUARE);
		TFullscreenWindow window = new TFullscreenWindow();
		TButton label = new TButton();
		label.setBounds(0, 0, 1080, 1080);
		window.add(label);
		window.showWindow();
	}

}