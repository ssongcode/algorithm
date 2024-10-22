import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String endl = "\n";
	static String blank = " ";

	static int k;
	static String[] arr;
	static int[] output;
	static boolean[] visited;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		k = Integer.parseInt(br.readLine());
		stk();
		arr = new String[k + 1];
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken();
		}
	}

	static void pro() throws IOException {
		output = new int[k + 1];
		visited = new boolean[10];
		list = new ArrayList<String>();
		recur(0);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}

	static void recur(int cur) throws IOException {
		if (!check(cur))
			return;

		if (cur == k + 1) {
			sb = new StringBuilder();
			for (int i = 0; i < k + 1; i++) {
				sb.append(output[i]);
			}
			list.add(sb.toString());
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visited[i])
				continue;
			output[cur] = i;
			visited[i] = true;
			recur(cur + 1);
			visited[i] = false;
		}
	}

	static boolean check(int cur) throws IOException {
		if (cur <= 1)
			return true;
		if (arr[cur - 2].equals("<") && output[cur - 2] > output[cur - 1])
			return false;
		if (arr[cur - 2].equals(">") && output[cur - 2] < output[cur - 1])
			return false;
		return true;
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}
