package util;

import java.lang.reflect.Type;
import java.util.Random;

public class TestHelper {
	static boolean headless;
	static Random rand;
	static final int RANDOMTESTCOUNT;
	static {
		headless = java.awt.GraphicsEnvironment.isHeadless();
		long seed = (long) (Math.random()*10000);
		System.out.println("SEED: '"+seed+"'");
		rand = new Random(seed);
		String env = System.getenv("fewerTests");
		if(env == null){
			
			RANDOMTESTCOUNT = 10000;
		}
		else{
			RANDOMTESTCOUNT = new Integer(env);
		}
	}
	
	
	public static boolean notHeadless(){
		return !headless;
	}
	/**
	 * 
	 * possible entries for types with their parameters:
	 * - Integer: maximum Number, Minimum Number
	 * - Boolean: alwaysValue
	 * 
	 * @param n Number of pseudo random Tests to be created
	 * @param values Test cases, that have to be covered
	 * @param types Objects to be generated for each line in the array
	 * @return
	 */
	public static Object[][] createRandomValues(int n, Object[][] values, String[][] types){
		assert(n>0);
		
		int l = values.length;
		Object[][] result = new Object[l+n][types.length];
		for(int i = 0; i<l; i++){
			result[i] = values [i];
		}
		
		for(int i = l; i<l+n ; i++){
			for(int j = 0; j<types.length;j++){
				switch (types[j][0]) {
				case "Integer":
					int min = 0;
					int max = Integer.MAX_VALUE;
					if(types[j][1]!=""){
						min=new Integer(types[j][1]);	
					}
					if(types[j][2]!=""){
						max=new Integer(types[j][2]);
					}
					result[i][j] =rand.nextInt(max)-min; 
					break;
				case "Boolean":
					if(types[j].length>1 && types[j][1]!="")
						result[i][j] =new Boolean(types[j][1]);
					else
						result[i][j] =rand.nextBoolean(); 
					break;
				default:
					assert(false);
				}
			}
		
		}		
		return result;
		
	}
	
	public static Object[][] createRandomValues(Object[][] values, String[][] types){
		return createRandomValues(RANDOMTESTCOUNT,values, types);
	}
	
}
