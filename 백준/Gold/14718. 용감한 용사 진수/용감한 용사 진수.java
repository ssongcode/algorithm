import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[][] arr;
	static int[] power, speed, intelligence;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][3];
		power = new int[N];
		speed = new int[N];
		intelligence = new int[N];
		for (int i = 0; i < N; i++) {
			stk();
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (j == 0) power[i] = arr[i][j];
				if (j == 1) speed[i] = arr[i][j];
				if (j == 2) intelligence[i] = arr[i][j];
			}
		}
	}

	static void pro() throws IOException {
		int p, s, in, sum, cnt;
		int min = 10000000;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					p = power[i];
					s = speed[j];
					in = intelligence[k];
					sum = p + s + in;
					cnt = 0;
					for(int l = 0; l < N; l++) {
						if(p >= arr[l][0] && s >= arr[l][1] && in >= arr[l][2]) {
							cnt++;
						}
						if(cnt >= K) {
							min = Math.min(min, sum);
						}
					}
				}
			}
		}
		System.out.println(min);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
