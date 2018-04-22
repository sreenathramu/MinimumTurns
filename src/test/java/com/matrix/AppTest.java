package com.matrix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testCase_1(){	
    	int R = 4,C = 3;
    	int board[][] = {{0,1,0},{0,1,0},{0,0,0},{0,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	int taken[][]= {{0,1},{1,1}};
    	assertEquals(3,app.minTurns(taken, 0, 0, 0, 2));
    }
    
    public void testCase_2(){	
    	int R = 4,C=3;
    	int board[][] = {{0,0,0},{0,1,0},{0,0,0},{0,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	int taken[][]= {{1,1}};
    	assertEquals(2,app.minTurns(taken, 0, 0, 0, 2));
    }
    
    public void testCase_3(){	
    	int R = 4,C=4;
    	int board[][] = {{0,1,0,0},
    					 {0,1,1,0},
    					 {0,0,0,0},
    					 {1,1,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	int taken[][]= {{0,1},{1,1},{1,2},{3,1},{3,2}};
    	assertEquals(3,app.minTurns(taken, 0, 0, 0, 2));
    }
    
    public void testCase_4(){	
    	int R = 8,C = 8;
    	int board[][] = {{0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,0,0,0,0,0,0,0},
    					 {0,0,0,0,0,0,0,0},
    					 {0,0,0,0,0,0,0,0},
    					 {0,0,0,0,0,0,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	int taken[][]= {{0,1},{1,1},{2,1},{3,1}};
    	assertEquals(3,app.minTurns(taken, 0, 0, 0, 2));
    }
    
    public void testCase_5(){	
    	int R = 8,C = 8;
    	int board[][] = {{0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0},
    					 {0,1,0,0,0,0,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	int taken[][]= {{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}};
    	assertEquals(65,app.minTurns(taken, 0, 0, 0, 2));
    }
}
