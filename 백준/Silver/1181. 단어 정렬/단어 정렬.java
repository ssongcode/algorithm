import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Set<String>[] cnt;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		cnt = new HashSet[51];
		for (int i = 1; i <= 50; i++) {
			cnt[i] = new HashSet<String>();
		}

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			cnt[str.length()].add(str);
		}
	}

	static void pro() throws IOException {
		List<String> list;
		for (int i = 1; i <= 50; i++) {
			list = new ArrayList<String>(cnt[i]);
			if (list.size() == 0)
				continue;
			Collections.sort(list);
			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}