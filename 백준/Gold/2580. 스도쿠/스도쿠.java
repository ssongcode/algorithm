import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] arr = new int[9][9], tmp = new int[9][9];
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		for (int i = 0; i < 9; i++) {
			stk();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tmp[i][j] = arr[i][j];
			}
		}
	}

	static void pro() throws IOException {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}

		recur(0);
	}

	static void recur(int cur) throws IOException {
		if (cur == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(tmp[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}

		int x = list.get(cur)[0];
		int y = list.get(cur)[1];

		for (int i = 1; i < 10; i++) {
			if (check(x, y, i)) {
				tmp[x][y] = i;
				recur(cur + 1);
				tmp[x][y] = 0;
			}
		}
	}

	static boolean check(int x, int y, int num) throws IOException {
		// 행, 열 검사
		for (int i = 0; i < 9; i++) {
			if (tmp[x][i] == num)
				return false;
			if (tmp[i][y] == num)
				return false;
		}

		// 박스 검사
		int dx = x / 3 * 3;
		int dy = y / 3 * 3;
		for (int i = dx; i < dx + 3; i++) {
			for (int j = dy; j < dy + 3; j++) {
				if (tmp[i][j] == num)
					return false;
			}
		}

		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
