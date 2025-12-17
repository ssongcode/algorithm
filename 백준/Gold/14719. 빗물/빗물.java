import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int H, W;
	static int[] arr, prefix, suffix;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[502];
		prefix = new int[502];
		suffix = new int[502];
		stk();
		for (int w = 1; w < W + 1; w++) {
			int h = Integer.parseInt(st.nextToken());
			arr[w] = h;
		}
	}

	static void pro() throws IOException {
		for (int i = 1; i <= 500; i++) {
			prefix[i] = Math.max(prefix[i - 1], arr[i]);
		}
		for (int i = 500; i > 0; i--) {
			suffix[i] = Math.max(suffix[i + 1], arr[i]);
		}
		
		int ans = 0;
		for (int i = 1; i <= 500; i++) {
			ans += Math.min(prefix[i], suffix[i]) - arr[i];
		}
		
		System.out.println(ans);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}