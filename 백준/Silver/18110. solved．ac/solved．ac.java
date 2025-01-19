import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

	static void pro() throws IOException {
		int cnt = 0, sum = 0, avg = 0;
		Arrays.sort(arr);
		cnt = (int) Math.round(n * 0.15);
		for (int i = 0 + cnt; i < n - cnt; i++) {
			sum += arr[i];
		}
		avg = Math.round((float) sum / (n - cnt * 2));
		System.out.println(avg);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}