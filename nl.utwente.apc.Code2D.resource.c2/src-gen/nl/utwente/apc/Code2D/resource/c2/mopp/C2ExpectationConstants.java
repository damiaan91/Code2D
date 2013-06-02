/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * This class contains some constants that are used during code completion.
 */
public class C2ExpectationConstants {
	
	public final static int EXPECTATIONS[][] = new int[10][];
	
	public static void initialize0() {
		EXPECTATIONS[0] = new int[2];
		EXPECTATIONS[0][0] = 0;
		EXPECTATIONS[0][1] = 0;
		EXPECTATIONS[1] = new int[2];
		EXPECTATIONS[1][0] = 1;
		EXPECTATIONS[1][1] = 1;
		EXPECTATIONS[2] = new int[2];
		EXPECTATIONS[2][0] = 2;
		EXPECTATIONS[2][1] = 2;
		EXPECTATIONS[3] = new int[3];
		EXPECTATIONS[3][0] = 3;
		EXPECTATIONS[3][1] = 3;
		EXPECTATIONS[3][2] = 0;
		EXPECTATIONS[4] = new int[2];
		EXPECTATIONS[4][0] = 4;
		EXPECTATIONS[4][1] = 4;
		EXPECTATIONS[5] = new int[2];
		EXPECTATIONS[5][0] = 5;
		EXPECTATIONS[5][1] = 6;
		EXPECTATIONS[6] = new int[2];
		EXPECTATIONS[6][0] = 6;
		EXPECTATIONS[6][1] = 7;
		EXPECTATIONS[7] = new int[2];
		EXPECTATIONS[7][0] = 7;
		EXPECTATIONS[7][1] = 8;
		EXPECTATIONS[8] = new int[2];
		EXPECTATIONS[8][0] = 8;
		EXPECTATIONS[8][1] = 9;
		EXPECTATIONS[9] = new int[2];
		EXPECTATIONS[9][0] = 4;
		EXPECTATIONS[9][1] = 10;
	}
	
	public static void initialize() {
		initialize0();
	}
	
	static {
		initialize();
	}
	
}
