import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int tc;
	static int[] pan, top;
	static int[] p = { 8, 8, 4, 1, 9 };
	static int[] t = { 1, 30, 25, 10 };

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		tc = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		for (int t = 0; t < tc; t++) {
			String str = br.readLine();
			pan = new int[5];
			stk();
			for (int i = 0; i < 5; i++) {
				pan[i] = Integer.parseInt(st.nextToken());
			}

			top = new int[4];
			stk();
			for (int i = 0; i < 4; i++) {
				top[i] = Integer.parseInt(st.nextToken());
			}

			sb.append(getCnt()).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int getCnt() throws IOException {
		int min = 10000000;
		for (int i = 0; i < 5; i++) {
			min = Math.min(min, (int) (16.0 * pan[i] / p[i]));
		}

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += top[i] / t[i];
		}

		return Math.min(min, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}