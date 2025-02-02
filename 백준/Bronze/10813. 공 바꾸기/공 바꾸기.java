import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int x, y;
		for (int i = 0; i < M; i++) {
			stk();
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			change(x, y);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	static void change(int i, int j) throws IOException {
		arr[0] = arr[i];
		arr[i] = arr[j];
		arr[j] = arr[0];
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}