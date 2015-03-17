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
import com.topahl.cutomSWING.swing.TPanel;

@RunWith(Parameterized.class)
public class TestTPanel {
	
	private int x,y,height,width;
	private TPanel panel;
	private final int TOLERANCE = 2; //TODO: Test
	private static int calls = 0;
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] {{ false, 10, 10, 10, 10} , { false, 1000 ,2000,3000, 4000 }};
	  String[][]types = {{"Boolean","false"},{"Integer","0","100000"},{"Integer","0","100000"},{"Integer","1","10000"},{"Integer","1","10000"}};
	  data = TestHelper.createRandomValues(data, types);
	  return Arrays.asList(data);
	}
	public TestTPanel(boolean autoscale ,int x, int y, int width, int height){
		calls++;
		TestHelper.progress(calls,1);
		TManager.getInstance().setAutoscale(autoscale);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Before
	public void createTPanel(){
		panel = new TPanel();
	}
	
	@Test
	public void testSetSize() {
		Dimension p = new Dimension(width,height); 
		panel.setSize(p);
		Dimension r = panel.getSize();
		
		assertEquals("Size hight was set:"+height+"but was"+r.height ,r.height, height, TOLERANCE);
		assertEquals("Size width was set:"+width+"but was"+r.width ,r.width, width, TOLERANCE);
	}
	

}
