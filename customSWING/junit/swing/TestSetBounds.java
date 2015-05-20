package swing;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.TestHelper;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TButton;
import com.topahl.cutomSWING.swing.TLabel;
import com.topahl.cutomSWING.swing.TLayeredPane;
import com.topahl.cutomSWING.swing.TPanel;
import com.topahl.cutomSWING.swing.TProgressBar;
import com.topahl.cutomSWING.swing.TTextField;
import com.topahl.cutomSWING.swing.TToggleButton;
import com.topahl.cutomSWING.swing.interfaces.TSetBounds;

@RunWith(Parameterized.class)
public class TestSetBounds {

	private int x, y, height, width;
	private final int TOLERANCE = 2;
	private static int calls = 0;
	private static Class classes[] = {TButton.class, TToggleButton.class, TLabel.class, TTextField.class, TPanel.class, TLayeredPane.class, TProgressBar.class};
	
	
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] { { true, 10 ,10 ,10 ,10 }, { false, 10, 10, 10, 10}, { true, 1000 ,2000,3000, 4000 } , { false, 1000 ,2000,3000, 4000 }};
	  String[][]types = {{"Boolean"},{"Integer","0","100000"},{"Integer","0","100000"},{"Integer","1","1000"},{"Integer","1","1000"}};
	  data = TestHelper.createRandomValues(data, types);
	  return Arrays.asList(data);
	}

	public TestSetBounds(boolean autoscale, int x, int y, int height, int width){
		calls++;
		TestHelper.progress(calls,6);
		TManager.getInstance().setAutoscale(autoscale);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	TSetBounds[] objects= new TSetBounds[classes.length];
	
	@Before
	public void createTObject(){
		for (int i = 0; i < classes.length; i++) {
			try {
				objects[i] = (TSetBounds) classes[i].newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Error creating Objects for TSetBounds Class: "+classes[i].getName());
			}
		}
	}
	
	
	@Test
	public void testSetBoundsRectangle() {
		for (TSetBounds object : objects) {
			object.setBounds(new Rectangle(x, y, width, height));
			Rectangle r = new Rectangle(); 
			object.getRealBounds(r);
			Dimension d = new Dimension();
			object.getRealSize(d);
			
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Bounds X",x, r.x, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Bounds Y",y, r.y, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Bounds hight",height, r.height, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Bounds width",width, r.width, TOLERANCE);
			
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Rectangle Size",height,d.height,TOLERANCE);
		}
	}
	
	@Test
	public void testSetBounds() {
		for (TSetBounds object : objects) {
			object.setBounds(x, y, width, height);
			Rectangle r = object.getRealBounds();
			Dimension d = object.getRealSize();
			
			
			assertEquals("Class: "+object.getClass().getName()+" Bounds X", x, r.x, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Bounds Y", y, r.y, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Bounds hight", height, r.height, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Bounds width", width, r.width, TOLERANCE);
			
			assertEquals("Class: "+object.getClass().getName()+" Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size",height,d.height,TOLERANCE);
		}
	}
	
	@Test
	public void testSetSizeDimension(){
		for (TSetBounds object : objects) {
			//Check whether set Sized changed x or y values;
			object.setBounds(new Rectangle(x,y,width,height));
			
			object.setSize(new Dimension(width, height));
			Dimension d = new Dimension();
			object.getRealSize(d);
			Rectangle r = new Rectangle();
			object.getRealBounds(r);
			
			
			assertEquals("Class: "+object.getClass().getName()+" Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size",height,d.height,TOLERANCE);
			
			assertEquals("Class: "+object.getClass().getName()+" Size stable X", x, r.x, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size stable Y", y, r.y, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size hight from Bounds", height, r.height, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Bounds width from Bounds", width, r.width, TOLERANCE);
		}
	}
	
	@Test
	public void testSetSizeDimensionNoBounds(){
		for (TSetBounds object : objects) {
			//Check whether set Sized changed x or y values;
			
			object.setSize(new Dimension(width, height));
			Dimension d = new Dimension();
			object.getRealSize(d);
			
			
			assertEquals("Class: "+object.getClass().getName()+" Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size",height,d.height,TOLERANCE);
		}
	}
	
	
	@Test
	public void testSetSizeNoBounds(){
		for (TSetBounds object : objects) {
			object.setSize(width, height);
			Dimension d = object.getRealSize();
			
			assertEquals("Class: "+object.getClass().getName()+" Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size",height,d.height,TOLERANCE);
		}
	}
	
	@Test
	public void testSetSize(){
		for (TSetBounds object : objects) {
			
			object.setBounds(x,y,width,height);
			
			object.setSize(width, height);
			Dimension d = object.getRealSize();
			Rectangle r = object.getRealBounds();
			
			assertEquals("Class: "+object.getClass().getName()+" Size",width,d.width,TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size",height,d.height,TOLERANCE);
			
			assertEquals("Class: "+object.getClass().getName()+" Size stable X", x, r.x, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size stable Y", y, r.y, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Size hight from Bounds", height, r.height, TOLERANCE);
			assertEquals("Class: "+object.getClass().getName()+" Bounds width from Bounds", width, r.width, TOLERANCE);
		}
	}
}
