package com.topahl.cutomSWING.master;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JComponent;

public class TManager {
	
	private static TManager instance;
	
	private boolean autoscale = true;
	private double scaleFactor;
	private HashMap<String, JComponent> objectStore;
	private Dimension screenSize;
	private Dimension gameSize;
	
	//Constants
	public static final int SCALE_SCREEN = 0;
	public static final int SCALE_FULLHD = 1;
	public static final int SCALE_SQUARE = 2;
	private final int[][] references= {{getScreenSize().width, getScreenSize().height},{1920,1080},{1080,1080}};
	//Constants end
	
	/**
	 * TManager Constructor
	 */
	private TManager(){
		//set Initial Values
		setScaleReference(SCALE_FULLHD);
	}
	
	
	/**
	 * TManager is a singleton implementation. This method can determine whether TManager was created yet.
	 * @return true if instance is initial
	 */
	private static boolean isInitial(){
		if(instance == null)
			return true;
		return false;
	}
	/**
	 * Resets the current TManager instance to its initial values
	 * @return The new instance of TManager
	 */
	public static TManager reset(){
		return instance = new TManager();
	} 
	
	/**
	 * TManager is a singleton implementation that can only be instantiated with this method
	 * @return current TManager instance
	 */
	public static TManager getInstance(){
		if(!isInitial())
			return instance;
		return reset();
	}
	
	/**
	 * Sets Autoscale to ON or OFF
	 * @param autoscale true = Autoscale ON
	 */
	public void setAutoscale(boolean autoscale){
		this.autoscale = autoscale;
	}
	
	/**
	 * Returns the current Selection for Auto scale
	 * @return true = Autoscale ON
	 */
	public boolean isAutoscale(){
		return autoscale;
	}
	
	/**
	 * Lets you specify a scaling factor for the scaling module. This will only apply to new created Components
	 * @param f the scaling factor to be used
	 */
	public void setAutoScaleFactor(double f){
		scaleFactor = f;
	}
	
	/**
	 * Gives you the current scaling factor for new created components
	 * @return current scaling Factor
	 */
	public double getAutoScaleFactor(){
		return scaleFactor;
	}
	
	/**
	 * Will register a Component inside the Component Store for later manipulation.
	 * @param key The key under which the component is stored
	 * @param comp The component that should be stored
	 * @return false = an error occurred
	 */
	public boolean registerComponent(String key ,JComponent comp){
		if(comp == null)
			return false;
		if(objectStore.put(key, comp)==null){
			return false;
		}
		return true;
	}
	
	/**
	 * Defines the scaling reference Model to keep the proportions. 
	 * @param ref Proportion model (Constants begin with SCALE_... )
	 */
	public void setScaleReference(int ref){
		double x = (double)getScreenSize().width/(double)references[ref][0];
		double y = (double)getScreenSize().height/(double)references[ref][1];
		if(y > x){
			setAutoScaleFactor(x);
			gameSize = new Dimension((int)(references[ref][0]*x),(int)(references[ref][1]*x));
		}else{
			setAutoScaleFactor(y);
			gameSize = new Dimension((int)(references[ref][0]*y),(int)(references[ref][1]*y));
		}

	}
	
	/**
	 * Returns the actual Screen Size of the Monitor.
	 * @return Screen Dimension
	 */
	public Dimension getScreenSize(){
		if(screenSize == null)
			try{
				screenSize=Toolkit.getDefaultToolkit().getScreenSize();
			}
			catch(HeadlessException e){
				System.err.println("Running in Headless Mode");
				screenSize= new Dimension(1080,1024);
			}
		return screenSize;	
	}
	
	public Dimension getGameSize(){
		return gameSize;
	}
}


