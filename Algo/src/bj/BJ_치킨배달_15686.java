package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_치킨배달_15686 {
	static int N, M, minCD, chickenCount;

	static ArrayList<int[]> houses = new ArrayList<>();
	static ArrayList<int[]> chickens = new ArrayList<>();
	static int[][] chickensLeft;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		chickensLeft = new int[M][M];
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int building = Integer.parseInt(st.nextToken());
				if(building == 1) houses.add(new int[]{i, j});
				if(building == 2) {chickens.add(new int[] {i,j});
					chickenCount ++;
				}
			}
		}
		
		
		
		minCD = Integer.MAX_VALUE;
		
		comb(0, 0);
		
		System.out.println(minCD);

	}
	
		
	static void comb(int srcIdx, int tgtIdx) {

		if(tgtIdx == M) {
			minCD = Math.min(minCD, getChickenDistance(houses, chickensLeft));	

			return;
		}
		if(srcIdx == chickenCount) return;
		chickensLeft[tgtIdx]=chickens.get(srcIdx);
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);	
	}
	
	static int getChickenDistance(ArrayList<int[]> houses, int[][] chickens) {
		int distance = 0;
		for(int[] house:houses) {
			int min = Integer.MAX_VALUE;
			for(int[] chicken:chickens) {
				min = Math.min(min, getChickenDistance(house, chicken));
				
			}
			distance += min;
		}		
		return distance;		
	}
	

	static int getChickenDistance(int[] house, int [] chicken) {
		int d = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
		return d;
	}
	

}
