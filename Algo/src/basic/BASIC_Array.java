package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BASIC_Array {

	public static void main(String[] args) {
		// 빈도수 체크
		// 소문자 알파벳 빈도수
//		{
//			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
//			int[] alphaCnt = new int[26]; // 0-25
//
//			int strLen = str.length();
//			for(int i = 0; i < strLen; i ++) {
//				alphaCnt[str.charAt(i) - 'a']++;
//			}
//			for(int i = 0; i < 26; i ++) {
//				System.out.println((char)(i+'a') + " " + alphaCnt[i]); // a 3
//			}
//		}
		
		
		// 규칙이 다른 경우의 수 출력
		// 세자리씩 묶어서 첫번째 수 * 두번째 수 = 세번째 수 (정상)
		// 비정상 개수
		
//		{
//			int [] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,2};
//			int wrongCnt = 0;
//			for(int i = 0; i < intArray.length-2; i+=3) {
//				System.out.println(i);
//				if(intArray[i] * intArray[i+1] != intArray[i+2]) wrongCnt++;
//		
//			}
//			System.out.println(wrongCnt);
//		}
		
		
		// 좌우 비대칭 문자 출력하고 개수 출력
		
//		{
//			String str = "XYZEBFFGQOVVPWGFFCEAYX";
//			char[] charArray = str.toCharArray();
//			int wrongCnt = 0;
//			for(int l = 0, r=charArray.length-1; l < charArray.length/2; l++, r--) {
//				if(charArray[l] != charArray[r]) {
//					System.out.print(charArray[l]);
//					System.out.print(charArray[r]);
//					System.out.println();
//					wrongCnt ++;
//				}
//			}
//			System.out.println(wrongCnt);
//			
//		}
		
		
		// 뒤집기 #1
		
//		{
//			String[] strArray = {"111", "222", "333", "444", "555", "666"};
//			String[] newArray = new String[strArray.length];
//			for(int i = 0,  t = strArray.length-1; i < strArray.length; i ++, t--) {
//				newArray[t] = strArray[i];
//			}
//			
//			System.out.println(Arrays.toString(newArray));
//		}
		
		
		// 뒤집기 #2
		{
			String[] strArray = {"111", "222", "333", "444", "555", "666"};
			List<String> strList = Arrays.asList(strArray);
			Collections.reverse(strList);
			System.out.println(Arrays.toString(strArray));
			
			
		}
	}

}
