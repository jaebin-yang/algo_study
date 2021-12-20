package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_암호문1_1228 {
	
	static int T = 10, N, M, X, Y;
	static Node header;
	static Node curr, currNext;
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input_1228.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			header = new Node(0);
			curr = header;
			
			for(int i = 0; i < N; i ++) {
				Node temp = new Node(Integer.parseInt(st.nextToken()));
				curr.setNext(temp);
				curr = temp;			
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i ++) {

				// I
				st.nextToken();
				X = Integer.parseInt(st.nextToken());
				
				Y = Integer.parseInt(st.nextToken());

				curr = header;
				getNode(0, X);
			

				currNext = curr.getNext();
				
				for(int j = 0; j < Y; j ++) {
					int num = Integer.parseInt(st.nextToken());
					Node temp = new Node(num);

					curr.setNext(temp);
					curr = temp;
					
				}
				curr.setNext(currNext);
							
			}
			
			System.out.print("#" + t + " ");
			int count = 0;
			curr = header.getNext();
			while(curr != null && count < 10) {
				System.out.print(curr.getNum() + " ");
				curr = curr.getNext();
				count ++;
			}
			System.out.println();
			
			
			
		}
		
		

	}
	
	public static void getNode(int currIdx, int idx) {

		if(curr == null) return;
		if(currIdx == idx) return;
		
		else {
			curr = curr.getNext();
			getNode(currIdx + 1, idx);
		}
		
		

	}
	


}

class Node {
	private int num;
	private Node next;
	
	
	Node(int num) {
		this.num = num;
		this.next = null;
	}
	
	Node(int num, Node next) {
		this.num = num;
		this.next = next;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}

	
}