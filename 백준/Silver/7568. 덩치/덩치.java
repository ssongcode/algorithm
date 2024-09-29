import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			stk();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1])
					cnt++;
			}
			sb.append(cnt+1).append(blank);
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
