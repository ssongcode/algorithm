import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String str;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
	}

	static void pro() throws IOException {
		int s = 0, e = 0;
		int cnt = 1, len = 1;
		int max = 0;
		char chS, chE;
		boolean[] visited;
		visited = new boolean[30];
		chS = str.charAt(s);
		visited[chS - 'a'] = true;
		e++;
		while (e < str.length()) {
			chE = str.charAt(e);
			if (visited[chE - 'a']) {
				len++;
			} else {
				visited[chE - 'a'] = true;
				cnt++;
				len++;
			}
			if (cnt == N + 1) {
				len--;
				max = Math.max(max, len);
				s++;
				e = s;
				visited = new boolean[30];
				cnt = 1;
				len = 1;
				chS = str.charAt(s);
				visited[chS - 'a'] = true;
			} else {
				max = Math.max(max, len);
			}
			e++;

		}
		System.out.println(max);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}