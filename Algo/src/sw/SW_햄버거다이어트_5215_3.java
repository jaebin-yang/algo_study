package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 3개 target
//2. 모든 target 1 ~ N
//3. tgt를 없앤다. => comb()을 통해서 새로운 조합을 만들 때, 칼로리를 체크한다. 
public class SW_햄버거다이어트_5215_3 {

	
	static int T, N, L, max;
	static Item[] src;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			src = new Item[N];
			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			max = 0;

			comb(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}

	}
	
	static void comb(int srcIdx, int point, int cal) {
		// 호출될 때 마다 조건 체크
		if(cal > L) return;

		// src 기저 조건 return
		if(srcIdx == N) {
			max = Math.max(point, max);
			return;
		}
		
		comb(srcIdx + 1, point + src[srcIdx].p, cal + src[srcIdx].c);
		comb(srcIdx + 1, point, cal);
		
	}
	
	static class Item{
		int p; // 맛 포인트 점수
		int c; // 칼로리
		
		public Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
		
	}

}
