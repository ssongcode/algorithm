import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] arr = new int[3][4];
	static char[] result = { 'E', 'A', 'B', 'C', 'D' };

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		for (int i = 0; i < 3; i++) {
			stk();
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
			System.out.println(result[cnt]);
		}
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}