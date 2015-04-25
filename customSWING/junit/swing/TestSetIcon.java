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
import com.topahl.cutomSWING.swing.interfaces.TSetIcon;
import com.topahl.cutomSWING.swing.interfaces.TSetIconExt;

@RunWith(Parameterized.class)
public class TestSetIcon{

	private int x, y, height, width;
	private final int TOLERANCE = 2;
	private static int calls = 0;
	private static Class classes[] = {TButton.class, TToggleButton.class, TLabel.class};
	
	
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] { { true, 10 ,10 ,10 ,10 }, { false, 10, 10, 10, 10}, { true, 1000 ,2000,3000, 4000 } , { false, 1000 ,2000,3000, 4000 }};
	  String[][]types = {{"Boolean"},{"Integer","0","100000"},{"Integer","0","100000"},{"Integer","1","1000"},{"Integer","1","1000"}};
	  data = TestHelper.createRandomValues(data, types);
	  return Arrays.asList(data);
	}

	public TestSetIcon(boolean autoscale, int x, int y, int height, int width){
		calls++;
		TestHelper.progress(calls,1);
		TManager.getInstance().setAutoscale(autoscale);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	TSetIcon[] objects= new TSetIcon[classes.length];
	
	@Before
	public void createTObject(){
		for (int i = 0; i < classes.length; i++) {
			try {
				objects[i] = (TSetIcon) classes[i].newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Error creating Objects for TSetIcon");
			}
		}
	}
	
	@Test
	public void testSetIcon(){
		for (TSetIcon object : objects) {
			object.setBounds(x, y, width, height);
			BufferedImage icon = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_ARGB);
			object.setIcon(new ImageIcon(icon));
		}
		
	}	
}
