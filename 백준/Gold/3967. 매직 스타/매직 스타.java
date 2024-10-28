import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static char[][] hexagram = new char[5][9];
	static int[] arr = new int[13];
	static int[] output = new int[13];
	static boolean[] visited = new boolean[13];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		int idx = 1;
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				char ch = str.charAt(j);
				hexagram[i][j] = ch;
				if (ch == '.')
					continue;
				else if (ch == 'x') {
					arr[idx] = 0;
				} else {
					arr[idx] = ch - 'A' + 1;
					output[idx] = arr[idx];
					visited[arr[idx]] = true;
				}
				idx++;
			}
		}
	}

	static void pro() throws IOException {
		recur(1);
		int idx = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (hexagram[i][j] == '.')
					System.out.print(hexagram[i][j]);
				else {
					System.out.print((char) (arr[idx] - 1 + 'A'));
					idx++;
				}
			}
			System.out.println();
		}
	}

	static void recur(int cur) throws IOException {
		if (cnt > 0)
			return;
		if (!check(cur))
			return;

		if (cur == 13) {
			if (!isMagicstar())
				return;
			cnt++;
			for (int i = 1; i <= 12; i++) {
				arr[i] = output[i];
//				System.out.print(arr[i] + " ");
			}
			return;
		}

		if (output[cur] != 0 && arr[cur] == output[cur])
			recur(cur + 1);
		else {

			for (int i = 1; i <= 12; i++) {
				if (visited[i])
					continue;
				output[cur] = i;
				visited[i] = true;
				recur(cur + 1);
				visited[i] = false;
			}
		}

	}

	static boolean check(int cur) throws IOException {
		return arr[cur - 1] == output[cur - 1] || arr[cur - 1] == 0;
	}

	static boolean isMagicstar() throws IOException {
		if (output[1] + output[3] + output[6] + output[8] != 26)
			return false;
		if (output[1] + output[4] + output[7] + output[11] != 26)
			return false;
		if (output[2] + output[3] + output[4] + output[5] != 26)
			return false;
		if (output[2] + output[6] + output[9] + output[12] != 26)
			return false;
		if (output[5] + output[7] + output[10] + output[12] != 26)
			return false;
		if (output[8] + output[9] + output[10] + output[11] != 26)
			return false;
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}