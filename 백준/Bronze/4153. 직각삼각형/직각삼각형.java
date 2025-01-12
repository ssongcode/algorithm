import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
	}

	static void pro() throws IOException {
		int[] arr = new int[3];

		int x, y, max = 0, idx = 0, sum = 0;
		while (true) {
			stk();
			sum = 0;
			max = 0;

			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > max) {
					max = arr[i];
					idx = i;
				}
			}

			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;

			for (int i = 0; i < 3; i++) {
				if (i == idx)
					continue;
				sum += arr[i] * arr[i];
			}

			if (sum == (max * max))
				sb.append("right").append("\n");
			else
				sb.append("wrong").append("\n");

		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}