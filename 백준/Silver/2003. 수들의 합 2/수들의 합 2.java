import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stk();
		arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() throws IOException {
		int s = 0, e = 0;
		int sum = arr[s];
		int cnt = 0;
		while (e < N) {
			if(sum == M) {
				cnt++;
				sum -= arr[s];
				s++;
				e++;
				sum += arr[e];
			}
			else if(sum < M) {
				e++;
				sum += arr[e]; 
			}
			else {
				sum -= arr[s];
				s++;
			}
		}
		System.out.println(cnt);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}