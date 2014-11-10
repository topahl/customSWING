package swing;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.topahl.cutomSWING.master.TManager;
import com.topahl.cutomSWING.swing.TLabel;

@RunWith(Parameterized.class)
public class TestTLabel {
	
	private int x, y, height, width;
	
	@Parameters
	public static Collection<Object[]> data() {
	  Object[][] data = new Object[][] { { true, 10 ,10 ,10 ,10 }, { false, 10, 10, 10, 10}, { true, 1000 ,2000,3000, 4000 } , { false, 1000 ,2000,3000, 4000 }};
	  return Arrays.asList(data);
	}

	public TestTLabel(boolean autoscale, int x, int y, int height, int width){
		TManager.getInstance().setAutoscale(autoscale);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}
	
	TLabel label;
	
	@Before
	public void createTLabel(){
		label = new TLabel();
	}
	
	@Test
	public void testSetBoundsRectangle() {
		label.setBounds(new Rectangle(x, y, width, height));
		Rectangle r = new Rectangle(); 
		label.getRealBounds(r);
		
		assertEquals("Rectangle Bounds X was set:"+x+"but was"+r.x ,r.x, x, 1);
		assertEquals("Rectangle Bounds Y was set:"+y+"but was"+r.y ,r.y, y, 1);
		assertEquals("Rectangle Bounds hight was set:"+height+"but was"+r.height ,r.height, height, 1);
		assertEquals("Rectangle Bounds width was set:"+width+"but was"+r.width ,r.width, width, 1);
	}
	
	@Test
	public void testSetBounds() {
		label.setBounds(x, y, width, height);
		Rectangle r = label.getRealBounds();
		
		assertEquals("Bounds X was set:"+x+"but was"+r.x ,r.x, x, 1);
		assertEquals("Bounds Y was set:"+y+"but was"+r.y ,r.y, y, 1);
		assertEquals("Bounds hight was set:"+height+"but was"+r.height ,r.height, height, 1);
		assertEquals("Bounds width was set:"+width+"but was"+r.width ,r.width, width, 1);
	}
	@Test
	public void testSetSizeDimension() {
		label.setSize(new Dimension(width, height));
		Dimension r = new Dimension(); 
		label.getRealSize(r);
		
		assertEquals("Dimension Size hight was set:"+height+"but was"+r.height ,r.height, height, 1);
		assertEquals("Dimension Size width was set:"+width+"but was"+r.width ,r.width, width, 1);
	}
	
	@Test
	public void testSetSize() {
		label.setSize(width, height);
		Dimension r = label.getRealSize();
		
		assertEquals("Size hight was set:"+height+"but was"+r.height ,r.height, height, 1);
		assertEquals("Size width was set:"+width+"but was"+r.width ,r.width, width, 1);
	}
	
	@Test
	public void testSetIcon(){
		label.setBounds(x, y, width, height);
		BufferedImage icon = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
		label.setIcon(new ImageIcon(icon));
	}
}
