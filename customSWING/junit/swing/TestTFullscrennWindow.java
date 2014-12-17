package swing;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.TestHelper;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TFullscreenWindow;
import com.topahl.cutomSWING.swing.TLabel;
   

@RunWith(Parameterized.class)
public class TestTFullscrennWindow {
	TFullscreenWindow window;
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] { { null}, { TManager.SCALE_FULLHD }, { TManager.SCALE_SCREEN }, { TManager.SCALE_SQUARE }};
	  return Arrays.asList(data);
	}
	
	public TestTFullscrennWindow(Integer ref){
		if(ref != null)
			TManager.getInstance().setScaleReference(ref);
	}
	
	@Before
	public void createTFullscreenWindow(){
		org.junit.Assume.assumeTrue(TestHelper.notHeadless());
		window = new TFullscreenWindow();
	}
	
	@After
	public void destroyTFullscreenWindow(){
		window.dispose();
	}
	
	@Test
	public void testShowWindow(){
		org.junit.Assume.assumeTrue(TestHelper.notHeadless());
		window.showWindow();
	}
	
	@Test
	public void testAddComponent(){
		org.junit.Assume.assumeTrue(TestHelper.notHeadless());
		window.add(new TLabel());
	}
}
