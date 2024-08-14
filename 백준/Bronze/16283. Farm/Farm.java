import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int a, b, n, w;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		stk();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
	}

	static void pro() throws IOException {
		int cnt = 0;
		int x = 0, y = 0;
		for (int i = 1; i < 1000; i++) {
			if (a * i + b * (n - i) == w) {
				if (n - i <= 0) continue;
				cnt++;
				x = i;
				y = n - i;
			}
		}
		if (cnt == 0 || cnt >= 2)
			System.out.print(-1);
		else
			System.out.print(x + blank + y);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
