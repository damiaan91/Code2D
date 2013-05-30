/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * This class contains some constants that are used during code completion.
 */
public class Code2DExpectationConstants {
	
	public final static int EXPECTATIONS[][] = new int[7][];
	
	public static void initialize0() {
		EXPECTATIONS[0] = new int[2];
		EXPECTATIONS[0][0] = 0;
		EXPECTATIONS[0][1] = 0;
		EXPECTATIONS[1] = new int[2];
		EXPECTATIONS[1][0] = 1;
		EXPECTATIONS[1][1] = 1;
		EXPECTATIONS[2] = new int[2];
		EXPECTATIONS[2][0] = 2;
		EXPECTATIONS[2][1] = 1;
		EXPECTATIONS[3] = new int[2];
		EXPECTATIONS[3][0] = 1;
		EXPECTATIONS[3][1] = 2;
		EXPECTATIONS[4] = new int[2];
		EXPECTATIONS[4][0] = 2;
		EXPECTATIONS[4][1] = 2;
		EXPECTATIONS[5] = new int[2];
		EXPECTATIONS[5][0] = 1;
		EXPECTATIONS[5][1] = 3;
		EXPECTATIONS[6] = new int[2];
		EXPECTATIONS[6][0] = 2;
		EXPECTATIONS[6][1] = 3;
	}
	
	public static void initialize() {
		initialize0();
	}
	
	static {
		initialize();
	}
	
}
