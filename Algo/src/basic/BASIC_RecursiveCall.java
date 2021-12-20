package basic;

public class BASIC_RecursiveCall {

	public static void main(String[] args) {
//		m1();
//		m2();
//		m2_correct();
//		m4(5 - 1);
//		m5(0);
		m6(0);
	}
	
	static void m1() {
		System.out.println("m1");
		m1();
	}
	
	static int m2_count = 5;
	static void m2() {
		System.out.println("앞 m2_count = " + m2_count);
		
		if(m2_count > 0) {
			m2_count -- ;
			m2();
		}

		System.out.println("뒤 m2_count = " + m2_count);
	}
	
	static int m2_correct_count = 5;
	static void m2_correct() {
//		System.out.println("앞 m2_count = " + m2_correct_count);

		// 기저조건 탈출조건 종료조건
		if(m2_correct_count == 0) {
			return;
		}
		System.out.println("앞 m2_count = " + m2_correct_count);
		
		m2_correct_count--;
		m2_correct();
		m2_correct_count++;
		System.out.println("뒤 m2_count = " + m2_correct_count);
	}
	

	static void m3(int m3_count) {

		// 기저조건 탈출조건 종료조건
		if(m3_count == 0) {
			return;
		}
		System.out.println("앞 m3_count = " + m3_count);
		

		m3(m3_count-1);

		System.out.println("뒤 m3_count = " + m3_count);
	}
	
	static int[] m4_intArr = {1, 2, 3, 4, 5};
	static void m4(int m4_count) {

	
		// 기저조건 탈출조건 종료조건
		if(m4_count < 0) {
			return;
		}
		System.out.println("앞 m4_intArr = " + m4_intArr[m4_count]);
		
		m4(m4_count - 1);

		System.out.println("뒤 m4_intArr = " + m4_intArr[m4_count]);
	}
	
	static int[] m5_intArr = {1, 2, 3, 4, 5};
	static void m5(int m5_count) {

	
		// 기저조건 탈출조건 종료조건
		if(m5_count >= m5_intArr.length) {
			// complete code
			System.out.println("Complete Code!!!!");
			return;
		}
		
		System.out.println("앞 m4_intArr = " + m4_intArr[m5_count]);
		
		m5(m5_count + 1);

		System.out.println("뒤 m4_intArr = " + m4_intArr[m5_count]);
	}
	
	static int[] m6_intArr = {1,2,3,4,5,6,7,8,9,10};
	static int m6_even_count = 0;
	static int m6_even_sum = 0;
	static int m6_count = 0;
//	static void m6(int m6_count) {
//		if(m6_count >= m6_intArr.length) {
//			System.out.println(m6_even_count + " "+ m6_even_sum);
//			return;
//		}
//		
//		if(m6_intArr[m6_count] % 2 == 0) {
//			m6_even_count ++;
//			m6_even_sum += m6_intArr[m6_count];
//		}
//		
//		m6(m6_count+1);
//	
//		
//	}
	
	static void m6(int m6_count) {
		if(m6_count >= 10) {
			System.out.println(m6_even_count);
			System.out.println(m6_even_sum);
			return;
		}
		
		if(m6_intArr[m6_count] % 2 == 0) {
			m6_even_count ++;
			m6_even_sum += m6_intArr[m6_count];
		}
		
		m6(m6_count+1);
	
		
	}

}
