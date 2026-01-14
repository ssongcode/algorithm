import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] lst;
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	static void pro() throws IOException {
		lst = new int[N];
		visited = new boolean[N];

		recur(0);

		System.out.println(cnt);
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;

		if (cur == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue; // 열처리
			lst[cur] = i;
			visited[i] = true;
			recur(cur + 1); // 행처리
			visited[i] = false;
		}
	}

	static boolean check(int cur) throws IOException {
		if (cur < 1)
			return true;

		for (int i = 0; i < cur - 1; i++) {
			// lst[cur-1] 이 lst[i]의 양 대각선에 놓여졌는지 확인
			if ((cur - 1 - i) == Math.abs(lst[cur - 1] - lst[i]))
				return false;
		}
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
