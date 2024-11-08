import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] num;
	static int[] oper;
	static char[] arr;
	static List<Character> list = new ArrayList<>();
	static boolean[] visited;
	static int min, max;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		oper = new int[4];
		stk();
		// 0:덧셈, 1:뺄셈, 2:곱셈, 3:나눗셈
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
			if (oper[i] == 0)
				continue;
			for (int j = 0; j < oper[i]; j++) {
				if (i == 0) {
					list.add('+');
				} else if (i == 1) {
					list.add('-');
				} else if (i == 2) {
					list.add('*');
				} else
					list.add('/');
			}
		}
	}

	static void pro() throws IOException {
		arr = new char[N - 1];
		visited = new boolean[N - 1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		recur(0);
		System.out.println(max);
		System.out.println(min);
	}

	static void recur(int cur) throws IOException {
		if (cur == N - 1) {
			check();
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if (visited[i])
				continue;
			arr[cur] = list.get(i);
			visited[i] = true;
			recur(cur + 1);
			visited[i] = false;
		}
	}

	static void check() throws IOException {
		int tmp = num[0];
		for (int i = 0; i < N - 1; i++) {
			tmp = cal(tmp, i);
		}
		min = Math.min(min, tmp);
		max = Math.max(max, tmp);
	}

	static int cal(int a, int idx) throws IOException {
		int tmp = 0;
		switch (arr[idx]) {
		case '+':
			tmp = a + num[idx + 1];
			break;
		case '-':
			tmp = a - num[idx + 1];
			break;
		case '*':
			tmp = a * num[idx + 1];
			break;
		case '/':
			tmp = a / num[idx + 1];
			break;
		}
		return tmp;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}