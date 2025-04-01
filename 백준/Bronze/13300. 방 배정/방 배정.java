import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] m, w;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 최대인원
		int s, grade;

		m = new int[7];
		w = new int[7];
		for (int i = 0; i < N; i++) {
			stk();
			s = Integer.parseInt(st.nextToken()); // 여0 남1
			grade = Integer.parseInt(st.nextToken());
			if (s == 0)
				w[grade]++;
			else
				m[grade]++;
		}
	}

	static void pro() throws IOException {
		int cnt = 0;
		for (int i = 1; i <= 6; i++) {
			cnt += check(w, i);
			cnt += check(m, i);
		}

		System.out.println(cnt);
	}

	static int check(int[] arr, int i) throws IOException {
		int cnt = 0;
		if (arr[i] % K == 0)
			cnt = arr[i] / K;
		else
			cnt = arr[i] / K + 1;
		return cnt;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}