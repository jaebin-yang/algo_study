package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_규영이와인영이의카드게임_6808 {

	// 규영 = true;
	// 인영 = false;
	static boolean [] deck, selected;
	static int cards[], cards2[], order[];
	static int T, win, lose;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T; t ++) {
			win = 0; lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			deck = new boolean[19];
			selected = new boolean[9];
			cards = new int[9];
			cards2 = new int[9];
			order = new int[9];
			
			for(int j = 0; j < 9; j ++) {
				int idx = Integer.parseInt(st.nextToken());
				deck[idx] = true;
				cards2[j] = idx;
			}
			int idx = 0;
			for(int j = 1; j <=18; j ++) {
				if(deck[j] == false) {
					cards[idx] = j;
					idx ++;
				}
			}
			
			perm(0);
			
			System.out.println("#" + t + " " + win + " " + lose);
			
		}
		
		
	}
	
	static void perm(int tgtIdx) {
		if(tgtIdx == 9)  {
			getOutcome();
			return;
		}

		for(int i = 0; i < 9; i ++) {
			if(selected[i]) continue;
			
			order[tgtIdx] = cards[i];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}

	}
	
	static void getOutcome() {
		int score1 = 0; int score2 = 0;
		for(int i = 0; i < 9; i ++) {
			if(cards2[i] > order[i]) {
				score2 += cards2[i] + order[i];
			}
			else {
				score1 += cards2[i] + order[i];
			}
		}
		
		if(score1 > score2) lose++;
		else if(score1 < score2) win++;
	}

}
