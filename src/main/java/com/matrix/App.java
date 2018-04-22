package com.matrix;


class Constants{
	
	public static final int DOWN = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
}

public class App 
{

	private int[][] board;
	private int[][] visited;
	private int R,C;
	
	
	
	public App(int[][] board, int[][] visited, int R, int C) {
		super();
		this.board = board;
		this.visited = visited;
		this.R = R;
		this.C = C;
	}


	public int min(int x,int y,int z,int w){
		if(x<=y && x<=z && x<=w)
			return x;
		else if(y<=x && y<=z && y<=w)
			return y;
		else if(w<=x && w<=y && w<=z)
			return w;
		else
			return z;
	}
	
	public int isBlock(int taken[][],int i,int j){
		int size = taken.length;
		for(int k=0;k<size;k++){
			if(taken[k][0] == i && taken[k][1] == j)
				return 1;
		}
		return 0;
	}

	
	public int findTurns(int taken[][],int i,int j,int eRow,int eCol,int rookDirection,int direction,int turn){
		
		if(i >= R || j >= C || i < 0 || j < 0){
			return (R*C)+1;
		}
		if(board[i][j] == 1 || visited[i][j] == 1){
			return (R*C)+1;
		}
		if(i == eRow && j == eCol){
			return turn+1;
		}

		visited[i][j] = 1;
		if(rookDirection != direction){
			turn += 1;
			rookDirection = direction;
		}
		
		int down = findTurns(taken,i+1,j,eRow,eCol,rookDirection,Constants.DOWN,turn);
		int right = findTurns(taken,i,j+1,eRow,eCol,rookDirection,Constants.RIGHT,turn);
		int up = findTurns(taken,i-1,j,eRow,eCol,rookDirection,Constants.UP,turn);
		int left = findTurns(taken,i,j-1,eRow,eCol,rookDirection,Constants.LEFT,turn);	
		
		visited[i][j] = 0;
		return min(down,right,left,up);
	}
	
	public int minTurns(int taken[][],int sRow,int sCol,int eRow,int eCol){
		return findTurns(taken, sRow, sCol, eRow, eCol, 0, Constants.DOWN, 0);
	}
	
    public static void main( String[] args )
    {
    	int R = 4,C=3;
    	int board[][] = {{0,1,0},{0,1,0},{0,0,0},{0,0,0}};
    	int visited[][] = new int[R][C];
    	for(int i=0;i<R;i++){
    		for(int j=0;j<C;j++){
    			visited[i][j] = 0;
    		}
    	}
    	App app =  new App(board,visited,R,C);
    	app.board = board;
    	app.visited = visited;
    	int taken[][]= {{0,1},{1,1}};
    	int turns = app.minTurns(taken, 0, 0, 0, 2);
    	System.out.println("Min Steps:"+turns);
    }
}


