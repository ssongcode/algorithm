import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, V;
	static int[] arr, cnt;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		cnt = new int[210];
		for (int i = 0; i < N; i++) {
			cnt[arr[i] + 100]++;
		}
		V = Integer.parseInt(br.readLine());
		System.out.println(cnt[V + 100]);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}