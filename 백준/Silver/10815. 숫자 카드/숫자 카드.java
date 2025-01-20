import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		cnt = new int[20_000_010];
		stk();
		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			cnt[tmp + 10_000_000]++;
		}
	}

	static void pro() throws IOException {
		M = Integer.parseInt(br.readLine());
		stk();
		int tmp;
		for (int i = 0; i < M; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if (cnt[tmp + 10_000_000] != 0)
				sb.append("1").append(" ");
			else
				sb.append("0").append(" ");
		}
		System.out.println(sb.toString());

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}