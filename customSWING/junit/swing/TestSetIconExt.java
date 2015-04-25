package swing;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.TestHelper;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TButton;
import com.topahl.cutomSWING.swing.TLabel;
import com.topahl.cutomSWING.swing.TToggleButton;
import com.topahl.cutomSWING.swing.interfaces.TSetIconExt;

@RunWith(Parameterized.class)
public class TestSetIconExt{

	private int x, y, height, width;
	private final int TOLERANCE = 2;
	private static int calls = 0;
	private static Class classes[] = {TButton.class, TToggleButton.class};
	
	
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] { { true, 10 ,10 ,10 ,10 }, { false, 10, 10, 10, 10}, { true, 1000 ,2000,3000, 4000 } , { false, 1000 ,2000,3000, 4000 }};
	  String[][]types = {{"Boolean"},{"Integer","0","100000"},{"Integer","0","100000"},{"Integer","1","1000"},{"Integer","1","1000"}};
	  data = TestHelper.createRandomValues(data, types);
	  return Arrays.asList(data);
	}

	public TestSetIconExt(boolean autoscale, int x, int y, int height, int width){
		calls++;
		TestHelper.progress(calls,5);
		TManager.getInstance().setAutoscale(autoscale);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	TSetIconExt[] objects= new TSetIconExt[classes.length];
	
	@Before
	public void createTObject(){
		for (int i = 0; i < classes.length; i++) {
			try {
				objects[i] = (TSetIconExt) classes[i].newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Error creating Objects for TSetIconExt");
			}
		}
	}
	
	@Test
	public void testSetPressedIcon(){
		for (TSetIconExt object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setPressedIcon(new ImageIcon(icon));
		}
		
	}
	
	@Test
	public void testSetRolloverIcon(){
		for (TSetIconExt object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setRolloverIcon(new ImageIcon(icon));
		}
		
	}
	
	@Test
	public void testSetRolloverSelectedIcon(){
		for (TSetIconExt object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setRolloverSelectedIcon(new ImageIcon(icon));
		}
		
	}
	
	@Test
	public void testSetSelectedIcon(){
		for (TSetIconExt object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setSelectedIcon(new ImageIcon(icon));
		}
		
	}
	
	@Test
	public void testSetDisabledIcon(){
		for (TSetIconExt object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setDisabledIcon(new ImageIcon(icon));
		}
		
	}
		
		
}
