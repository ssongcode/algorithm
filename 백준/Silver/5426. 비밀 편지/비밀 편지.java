import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int tc;

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
			int n = (int) Math.sqrt(str.length());
			char[][] arr = new char[n][n];
			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(k);
					k++;
				}
			}

			for (int j = n - 1; j >= 0; j--) {
				for (int i = 0; i < n; i++) {
					sb.append(arr[i][j]);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
