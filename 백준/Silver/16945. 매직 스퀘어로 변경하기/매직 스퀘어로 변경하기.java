import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] arr, tmp;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			stk();
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() throws IOException {
		tmp = new int[3][3];
		visited = new boolean[10];

		recur(0, 0);
		System.out.println(min);
	}

	static void recur(int x, int y) throws IOException {
		if (y == 3) {
			x++;
			y = 0;
		}
		if (x == 3) {
			if (!check())
				return;
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sum += Math.abs(arr[i][j] - tmp[i][j]);
				}
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (visited[i])
				continue;
			tmp[x][y] = i;
			visited[i] = true;
			recur(x, y + 1);
			visited[i] = false;
		}
	}

	static boolean check() throws IOException {
		int sum;
		for (int i = 0; i < 3; i++) {
			sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += tmp[i][j];
			}

			if (sum != 15)
				return false;
		}

		for (int j = 0; j < 3; j++) {
			sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += tmp[i][j];
			}

			if (sum != 15)
				return false;
		}

		if (tmp[0][0] + tmp[1][1] + tmp[2][2] != 15)
			return false;
		if (tmp[0][2] + tmp[1][1] + tmp[2][0] != 15)
			return false;

		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}