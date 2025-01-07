import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int[] arr = new int[9];
	static int sum;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
	}

	static void pro() throws IOException {
		Arrays.sort(arr);
		Loop: for (int i = 0; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j) continue;
						sb.append(arr[k]).append(endl);
					}
					break Loop;
				}
			}
		}
		System.out.print(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
