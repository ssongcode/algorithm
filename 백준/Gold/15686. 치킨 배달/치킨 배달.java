import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;
	static List<Chicken> store;
	static int[] arr;
	static boolean[] visited;
	static int minLength = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		store = new ArrayList<>();
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			stk();
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					store.add(new Chicken(r, c));
				}
			}
		}
	}

	static void pro() throws IOException {
		arr = new int[M];
		visited = new boolean[store.size()];
		recur(0, 0);
		System.out.println(minLength);
	}

	static void recur(int cur, int start) throws IOException {
		if (cur == M) {
			getChickenLength(arr);
			return;
		}

		for (int i = start; i < store.size(); i++) {
			if (visited[i])
				continue;
			arr[cur] = i;
			visited[i] = true;
			recur(cur + 1, i + 1);
			visited[i] = false;
		}
	}

	static void getChickenLength(int[] arr) throws IOException {
		int min = 0;
		int sum = 0;
		int tmp = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 1) {
					min = Integer.MAX_VALUE;
					for (int i = 0; i < arr.length; i++) {
						Chicken chickenStore = store.get(arr[i]);
						tmp = Math.abs(chickenStore.r - r) + Math.abs(chickenStore.c - c);
						min = Math.min(min, tmp);
					}
					sum += min;
				}
			}
		}
		minLength = Math.min(sum, minLength);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Chicken {
		int r;
		int c;

		public Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}