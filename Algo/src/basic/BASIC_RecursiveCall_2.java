package basic;

import java.util.ArrayList;
import java.util.Random;

public class BASIC_RecursiveCall_2 {

	static Random random = new Random();
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		//rand(0,0,0);
//		System.out.println(rand2(0,0)); // 짝수의 개수
//		int cnt = rand3(0);

		if(rand4(0) ) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		
		for(int n : list) {
			System.out.print(n+" ");
		}

	}
	
	// 10보다 작은 난수를 발생
	// 이전 재귀호출 포함 난수의 함(sum) 100 보다 크면 종료
	// 종료 : 난수의 총합 , 짝수의 개수, 3의 배수의 개수
	
	static void rand(int sum, int evenCnt, int threeCnt) {
		// 기저조건
		// if() 지금까지 발생한 난수의 합이 100보다 크면 종료
		// sum, evenCnt, threeCnt 출력
		// list 출력
		if(sum>100) {
			System.out.println(sum);
			System.out.println(evenCnt);
			System.out.println(threeCnt);
			for(int n : list) {
				System.out.print(n+" ");
			}
			return;
		}
		
		int n = random.nextInt(10);
		list.add(n);
		int even = 0;
		if(n%2==0) even ++;
		int three = 0;
		if(n%3==0) three ++;
		
		rand(sum + n, evenCnt + even, threeCnt + three);
	}
	
	static int rand2(int sum, int evenCnt) {
		// 기저조건
		// if() 지금까지 발생한 난수의 합이 100보다 크면 종료
		// list 출력
		
		if(sum > 100) {
			for(int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
			return evenCnt;
		}
		
		int n = random.nextInt(10);
		list.add(n);
		
		int even = 0;
		if(n%2 == 0) even++;
		return rand2(sum+n, evenCnt+even);
	}

	static int rand3(int sum) {
		// 기저조건
		// if() 지금까지 발생한 난수의 합이 100보다 크면 종료
		// list 출력
		
		if(sum > 100) {
			for(int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
			return 0;
		}
		
		int n = random.nextInt(10);
		list.add(n);
		
		int even = 0;
		if(n%2 == 0) even++;
		return even + rand3(sum+n);
	}
	
	
	// 연속적으로 성공 여부
	// 난수가 연속적으로 5회 8보다 작은 수가 나오면 true / false
	static boolean rand4(int underEightCnt) {
		if(underEightCnt == 5) return true;
		int n = random.nextInt(10);
		list.add(n);
		
		if(n<8) {
			return rand4(underEightCnt + 1);
		}else {
			return false;
		}
	}
}
