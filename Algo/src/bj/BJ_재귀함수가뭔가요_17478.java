package bj;

import java.util.Scanner;

public class BJ_재귀함수가뭔가요_17478 {

	static int N;
	static String[] MSG_ARRAY =
		{"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
		"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
		"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		chatbot(0);

	}

	static void chatbot(int depth) {
		// 들여쓰기 + 재귀 함수가 뭔가요?
		for (int i = 0; i < depth; i++) System.out.print("____");
		System.out.println("\"재귀함수가 뭔가요?\"");
		
		// 기저 조건
		if( depth == N ) {
			
			// 마지막 출력
			for (int i = 0; i < depth; i++) System.out.print("____");
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for (int i = 0; i < depth; i++) System.out.print("____");
			System.out.println("라고 답변하였지.");
			return;			
		}
		
		// 들여쓰기 + 잘 들어보게....
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < depth; j++) System.out.print("____");
			System.out.println(MSG_ARRAY[i]);
		}
				
		chatbot( depth + 1);
		
		// 들여쓰기 + 라고 답변...
		for (int i = 0; i < depth; i++) System.out.print("____");
		System.out.println("라고 답변하였지.");
	}
}
