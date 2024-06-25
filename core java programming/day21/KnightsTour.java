package day21;

public class KnightsTour {
	private static final int N=8;
	
	private static boolean isSafe(int x, int y, int[][] board) {
		return (x>=0 && x<N && y>=0 && y<N && board[x][y]==-1);
	}
	
	private static void printSolution(int[][] board) {
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				System.out.print(board[x][y]+" ");
			}
			System.out.println();
		}
	}
	
	private static boolean solveKT() {
		int[][] board=new int[N][N];
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				board[x][y]=-1;
			}
		}
		int[] xMove= {2,1,-1,-2,-2,-1,1,2};
		int[] yMove= {1,2,2,1,-1,-2,-2,-1};
		board[0][0]=0;
		
		if(!solveKTUtil(0,0,1,board,xMove,yMove)) {
			System.out.println("Solution does not exist ");
			return false;
		}else {
			printSolution(board);
		}
		return true;
	}
	private static boolean solveKTUtil(int x,int y,int moveCount,int[][] board,int[] xMove,int[] yMove) {
		int next_x, next_y;
		if(moveCount==N*N) {
			return true;
		}
		for(int k=0;k<8;k++) {
			next_x=x+xMove[k];
			next_y=y+yMove[k];
			if(isSafe(next_x,next_y,board)) {
				board[next_x][next_y]=moveCount;
				if(solveKTUtil(next_x,next_y,moveCount+1,board,xMove,yMove)) {
					return true;
				}else {
					board[next_x][next_y]=-1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solveKT();
	}

}
