package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_스도쿠_2239 {
	
	static int[][] sudoku;
	static boolean done;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		
		for(int i = 0; i < 9; i ++) {
			String s = br.readLine();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
			}
		}
		
		done = false;
		dfs(0);
		
		for(int i = 0; i < 9; i ++) {
			for(int j = 0; j < 9; j ++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
		
	}

	static void dfs(int count) {
		if(count == 81) {
			done = true;
			return;
		}
		int y = count/9;
		int x = count%9;
		
		if(sudoku[y][x] == 0) {
			for(int i = 1; i <= 9; i ++) {
				if(canInsert(y, x, i)) {
					sudoku[y][x] = i;
					dfs(count+1);
					if(done) return;
					sudoku[y][x] = 0;
				}
			}
		}
		else {
			dfs(count+1);
		}
	}
	
	static boolean canInsert(int y, int x, int num) {
		for(int i = 0; i < 9; i ++) {
			if(sudoku[y][i] == num || sudoku[i][x] == num) return false;
		}
		
		int boundY = y / 3 * 3;
		int boundX = x / 3 * 3;
		for(int i = boundY; i < boundY + 3; i ++) {
			for(int j = boundX; j < boundX + 3; j ++) {
				if(sudoku[i][j] == num) return false;
			}
		}
		
		return true;
	}

	

}
