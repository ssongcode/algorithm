import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, min;
	static int[][] arr;
	static int[] base;
	static List<Integer> list, answer;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		base = new int[4];
		stk();
		for (int i = 0; i < 4; i++) {
			base[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		min = Integer.MAX_VALUE;
		list = new ArrayList<Integer>();
		int[] sum = new int[5];

		recur(0, sum);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(min);
			for (int i = 0; i < answer.size(); i++) {
				System.out.print(answer.get(i) + " ");
			}
		}
	}

	static void recur(int cur, int[] sum) throws IOException {
		if (cur == N)
			return;

		int[] tmp = new int[5];
		for (int i = 0; i < 5; i++) {
			tmp[i] = sum[i] + arr[cur][i];
		}
		list.add(cur + 1);

		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (tmp[i] < base[i]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			if (min > tmp[4]) {
				min = tmp[4];
				answer = new ArrayList<Integer>(list);
			}
		}

		recur(cur + 1, tmp);
		list.remove(list.size() - 1);

		recur(cur + 1, sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}