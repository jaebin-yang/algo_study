package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_암호생성기_1225 {

	static String num;
	static int N;
	static int count;
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			num = br.readLine();
			if(num == null) break;
			queue.clear();
			N = Integer.parseInt(num);
			StringTokenizer st = new StringTokenizer(br.readLine());
			// add elements to queue
			for(int i = 0; i<8; i ++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			count = 1;
			while(true) {
				if(queue.peek() - count <= 0) {
					queue.poll();
					queue.add(0);
					break;
				}

				int temp = queue.poll() - count;
				queue.add(temp);
				count = count==5? 1:count+1;

			}
			System.out.print("#" + N + " ");
			for(int i = 0; i < 8; i ++) {
				System.out.print(queue.poll()+ " ");
			}
			System.out.println();
		}
		

	}
	

}
