package bj;

import java.util.Scanner;

public class BJ_설탕배달_2839_greedy {

	static int N, threeCnt; // 3을 사용하는 횟수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		while(true) {
			
			if( N < 0 ) {
				System.out.println(-1);
				break;
			}
			
			if( N % 5 == 0 ) {
				System.out.println(N/5 + threeCnt);
				break;
			}else {
				N -= 3;
				threeCnt++;
			}
		}
		
		sc.close();
	}
}
