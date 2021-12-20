package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.StringTokenizer;


class SW_상호의배틀필드_1873
{
	static int H,W;
	static char[][] battlefield;
	static int tankY, tankX;
	static int dy[] = {-1, 1, 0, 0, 0};
	static int dx[] = {0, 0, -1, 1, 0};

	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			battlefield = new char[H][W];
			for(int i = 0; i < H; i++) {
				String elements = br.readLine();
				for(int j = 0; j < W; j++) {
					battlefield[i][j] = elements.charAt(j);
				}
			}
			//            System.out.println(Arrays.deepToString(battlefield));

			// find current location of tank
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j ++ ) {
					if(battlefield[i][j] == 'v'  || battlefield[i][j] == '^' || battlefield[i][j] == '<' || battlefield[i][j] == '>') {
						tankY = i;
						tankX = j;
					}
				}
			}
			int num = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			// operate tank around the battlefield
			for(int i = 0; i < num; i ++) {
				operateTank(commands.charAt(i));

			}

			System.out.print("#" + test_case + " ");
			for(int i = 0; i < H; i ++) {
				for(int j = 0; j < W; j ++) {
					System.out.print(battlefield[i][j]);
				}
				System.out.println();
			}


		}
	}

	static void operateTank(char command) {
		int x = 0; int y = 0;
		switch(command) {
		case 'U' : 
			battlefield[tankY][tankX] = '^';
			y = dy[0];
			x = dx[0];
			break;
		case 'D' : 
			battlefield[tankY][tankX] = 'v';
			y = dy[1];
			x = dx[1];
			break;
		case 'L' : 
			battlefield[tankY][tankX] = '<';
			y = dy[2];
			x = dx[2];
			break;
		case 'R' : 
			battlefield[tankY][tankX] = '>';
			y = dy[3];
			x = dx[3];
			break;
		case 'S' : 
			shoot(battlefield[tankY][tankX]); 
			y = dy[4]; x = dx[4];
			break;
		}
		if(tankX + x < W && tankY + y < H && tankX + x >= 0 && tankY + y >= 0 &&  battlefield[tankY + y][tankX + x] == '.') {
			battlefield[tankY + y][tankX + x] = battlefield[tankY][tankX];
			battlefield[tankY][tankX] = '.';
			tankX += x; tankY += y;
		}


	}

	static void shoot(char direction) {
		int y = 0;
		int x = 0;
		// current location of cannonball
		int cbY = tankY;
		int cbX = tankX;
		switch(direction) {
		case '^': y = dy[0]; x = dx[0]; break;
		case 'v': y = dy[1]; x = dx[1]; break;
		case '<': y = dy[2]; x = dx[2]; break;
		case '>': y = dy[3]; x = dx[3]; break;
		}
		while(cbY + y >= 0 && cbX + x >= 0 && cbY + y < H && cbX + x < W) {
			if(battlefield[cbY + y][cbX + x] == '*') {
				battlefield[cbY + y][cbX + x] = '.';
				break;
			}
			if(battlefield[cbY + y][cbX + x] == '#') {
				break;
			}			
			cbY += y; cbX +=x;						
		}

	}




}