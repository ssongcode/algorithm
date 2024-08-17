import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int[][] square = new int[101][101];
		for (int i = 0; i < n; i++) {
			for (int j = arr[i][0]; j < arr[i][0] + 10; j++) {
				for (int k = arr[i][1]; k < arr[i][1] + 10; k++) {
					square[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (square[i][j] != 0)
					sum += square[i][j];
			}
		}
		System.out.print(sum);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}