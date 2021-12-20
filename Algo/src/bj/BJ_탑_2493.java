package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_탑_2493 {

	static int N, Curr;
	static Stack<int[]> towers = new Stack<>();
	static int Receiver;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i ++) {
			Curr = Integer.parseInt(st.nextToken());
			if(i == 1) {
				towers.push(new int[]{i, Curr});

				Receiver = 0;
			}
			else {
				while(!towers.isEmpty()) {
					if(Curr > towers.peek()[1]) {
						Receiver = 0;
						towers.pop();
					}
					else {
						Receiver = towers.peek()[0];
						break;
					}
				}
				towers.push(new int[]{i, Curr});
			}
			System.out.print(Receiver + " ");

		}
	}

}
