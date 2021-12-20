package sw;

public class SW_구간합_5604_연습 {
	static long ans;
	public static void main(String[] args) {
		// 127 => 1 + 2 + 7 = 10

		
//		System.out.println(calcTen(127));
//		System.out.println(calcRet(128, 1));
//		System.out.println(calcRet(128, 10));
		
		
		int A = 80;
		int B = 120;
		
		ans = 0;
		long pos = 1; // 자리수
		while(A <= B) { // 반복마다 자리수 감소
			// 시작 일부 부분 
			// 8, 12
			// 8 + 9 = 17
			
			// 80
			while(A % 10 != 0 && A <= B) {
				calc(A, pos);
				A ++;
			}
			
			if(A > B || (A==0 && B == 0)) break;
			
			// 끝 일부 부분
			// 8, 12
			// 12 + 11 + 10 (3+2+1)  ** 6
			
			// 80, 120
			// 120 (1+2+0) 3을 ans에 더하고, 119
			while(B % 10 != 9 && A <= B) {
				calc(B, pos);
				B --;
			}
			
			// A 10 
			// B 9
			
			// A 80
			// B 119
			
			A /= 10;
			B /= 10;
			
			// A: 8, B: 11
			// 덩어리 사각형
			long m = (B-A+1) * pos; // m:4
			// 80-81-82...89 | 90-91-92...99 | 100-101-102... | 110-111-112...119 
			for(int i = 0; i < 10; i ++) { // 10개
				ans += m * i; // 4 * 0 + 4 *1+ 4*2 + ......
			}
			

			
			pos *= 10;
			
			
		}
		System.out.println(ans);
		
	}
	
	// 8, 10
	static void calc(long n, long t) {
		while (n > 0) {
			ans += (n%10)*t;
			n /= 10;
		}
	}
	
	static long calcTen(long n) {
		long sum = 0;
		while(n > 0) {
			sum += (n%10);
			n /= 10;
		}
		
		return sum;
	}
	
	static long calcRet(long n, long t) {
		long sum = 0;
		while(n>0) {
			sum += (n%10) * t;
			n /= 10;
		}
		
		return sum;
	}

}
