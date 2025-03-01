import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String doc;
	static String word;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		doc = br.readLine();
		word = br.readLine();
	}

	static void pro() throws IOException {
		boolean[] visited = new boolean[2510];
		int len = doc.length(), n = word.length();
		int cnt = 0, ans = 0;
		for (int i = 0; i <= len - n; i++) {
			if (visited[i])
				continue;
			cnt = 0;
			for (int j = i; j < i + n; j++) {
				if (doc.charAt(j) == word.charAt(j - i)) {
					visited[j] = true;
					cnt++;
				}
			}
			if (cnt == n) {
				ans++;
			} else {
				for (int j = i; j < i + n; j++) {
					visited[j] = false;
				}
			}
		}

		System.out.println(ans);

	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}