package swing;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
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

@RunWith(Parameterized.class)
public class TestTButton {
	TButton button;
	int width, height;
	private final int TOLERANCE = 2;
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] {{false, 3000, 4000 },{false, 10, 10 }};
	  String[][]types = {{"Boolean","false"},{"Integer","1","10000"},{"Integer","1","10000"}};
	  data = TestHelper.createRandomValues(data, types);
	  return Arrays.asList(data);
	}

	public TestTButton(boolean autoscale, int height, int width) {
		TManager.getInstance().setAutoscale(autoscale);
		this.height=height;
		this.width=width;
	}
	
	@Before
	public void createTButton(){
		button = new TButton();
	}
	
	@Test
	public void testSetSizeDimension() {
		button.setSize(new Dimension(width, height));
		Dimension r = new Dimension(); 
		button.getSize(r);
		
		assertEquals("Dimension Size hight was set:"+height+"but was"+r.height ,r.height, height, TOLERANCE);
		assertEquals("Dimension Size width was set:"+width+"but was"+r.width ,r.width, width,TOLERANCE);
	}	
}
