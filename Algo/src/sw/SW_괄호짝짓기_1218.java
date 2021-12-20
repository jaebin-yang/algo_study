package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_괄호짝짓기_1218 {
	
	static Stack<Character> stack;
	static int N;
	static Character temp;
	static int result;
		
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t = 1; t <= 10; t ++) {
			stack = new Stack<>();
			// 괄호 종류 = ( ) [ ] < > { } 
			N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();

			for(int i = 0; i < N; i ++) {
				temp = input.charAt(i);
				if(temp == '(' || temp == '[' || temp == '<' || temp == '{') {
					stack.push(temp);
					continue;
				}
				switch(temp) {
				case(')'):
					if(stack.peek() == '(') stack.pop(); 
					else stack.push(temp);
					break;
				case(']'):
					if(stack.peek() == '[') stack.pop(); 
					
					else stack.push(temp);
					break;
				case('>'):
					if(stack.peek() == '<') stack.pop(); 
					else stack.push(temp);
				 	break;
				case('}'):
					if(stack.peek() == '{') stack.pop(); 					
					else stack.push(temp);
					break;
				}				
			}	
			
			result = stack.isEmpty()? 1:0;
			
			System.out.println("#" + t + " " + result);
			
		}
		
	}
}
