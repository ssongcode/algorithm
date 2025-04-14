import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, P, score;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		if (N == 0)
			return;
		arr = new int[P];
		stk();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int ans;

		if (N == 0)
			ans = 1;
		else {
			ans = -1;
			int[] grade = new int[P];
			int tmp = 0;

			for (int i = 0; i < P; i++) {
				tmp++;
				if (i == 0)
					grade[i] = 1;
				else if (arr[i] == arr[i - 1])
					grade[i] = grade[i - 1];
				else
					grade[i] = tmp;
			}

			for (int i = 0; i < P; i++) {
				if (score > arr[i]) {
					ans = grade[i];
					break;
				} else if (score == arr[i]) {
					if (score == arr[N - 1] && N == P)
						ans = -1;
					else
						ans = grade[i];
					break;
				}

			}
		}

		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}