package swing;

public class TestHelper {
	static boolean headless;
	static {
		headless = java.awt.GraphicsEnvironment.isHeadless();
	}
	public static boolean notHeadless(){
		if(headless)
			return false;
		return true;
	}
}
