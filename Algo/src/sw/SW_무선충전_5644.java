package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_무선충전_5644 {
	static int T, M, A, ay, ax, by, bx;
	static int [] aMove, bMove;
	static BC[] chargers;
	static ArrayList<BC> chargeOptionsA;
	static ArrayList<BC> chargeOptionsB;
	static int sum, combSum;
	
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			ay = 1; ax = 1; by = 10; bx = 10; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			aMove = new int[M+1];
			bMove = new int[M+1];
			
			chargers = new BC[A];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i ++) {
				aMove[i] = Integer.parseInt(st1.nextToken());
				bMove[i] = Integer.parseInt(st2.nextToken());
			}
			
			
			for(int i = 0; i < A; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				chargers[i] = new BC(y, x, c, p);
			}

			sum = 0;
			
			for(int i = 0; i <= M; i ++) {
				ay += dy[aMove[i]];
				ax += dx[aMove[i]];
				by += dy[bMove[i]];
				bx += dx[bMove[i]];
				chargeOptionsA = canCharge(ay, ax);
				chargeOptionsB = canCharge(by, bx);
				

				
				if(chargeOptionsA.size() == 0 && chargeOptionsB.size() == 0) {
					continue;
				} else if(chargeOptionsA.size() == 0) {
					sum += chargeOptionsB.get(0).Performance;
					continue;
				} else if(chargeOptionsB.size() == 0) {
					sum += chargeOptionsA.get(0).Performance;
					continue;
				}
				
				if(chargeOptionsA.get(0).equals(chargeOptionsB.get(0))) {
					combSum = 0;
					bestComb(chargeOptionsA, chargeOptionsB, 0, 0);
					sum += combSum;
				} else {
					sum += chargeOptionsA.get(0).Performance;
					sum += chargeOptionsB.get(0).Performance;
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
	static void bestComb(ArrayList<BC> a, ArrayList<BC> b, int src1, int src2) {
		
		if(src1 == a.size()) return;
		if(src2 == b.size()) return;
		int sum = 0;
		if(a.get(src1).equals(b.get(src2))) {
			sum = a.get(src1).Performance;
		} else {
			sum = a.get(src1).Performance + b.get(src2).Performance;
		}
		
		if(combSum < sum) combSum = sum;
		
		bestComb(a, b, src1 + 1, src2 + 1);
		bestComb(a, b, src1, src2 + 1);
		bestComb(a, b, src1 + 1, src2);
	}

	
	
	static int getDistance(int y, int x, BC bc) {
		return Math.abs(y - bc.y) + Math.abs(x - bc.x);
	}
	
	static ArrayList<BC> canCharge(int y, int x){
		ArrayList<BC> pChargers = new ArrayList<BC>();
		
		for(int i = 0; i < A; i ++) {
			if(getDistance(y, x, chargers[i]) <= chargers[i].Coverage) {
				pChargers.add(chargers[i]);
			}
		}
		
		Collections.sort(pChargers, (c1, c2) -> c2.Performance - c1.Performance);
		return pChargers;
	}
	
	static class BC {
		int y, x;
		int Coverage;
		int Performance;
		
		BC(int y, int x, int c, int p) {
			super();
			this.y = y;
			this.x = x;
			this.Coverage = c;
			this.Performance = p;
		}
		
		public boolean equals(BC b) {
			return this.x == b.x && this.y == b.y;
		}
		
	}
}
