import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String input;
	static int N;
	static ArrayList<String>[] arr;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		input = br.readLine();
	}

	static void pro() throws IOException {
		N = input.length();
		arr = new ArrayList[30];
		for (int i = 0; i < 30; i++) {
			arr[i] = new ArrayList<String>();
		}
		// 0~i, i+1~j, j+1~N-1
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				reverse(i, j);
			}
		}
		for (int i = 0; i < 30; i++) {
			if (arr[i].isEmpty())
				continue;
			Collections.sort(arr[i]);
			System.out.println(arr[i].get(0));
			break;
		}

	}

	static void reverse(int i, int j) throws IOException {
		String str1 = "", str2 = "", str3 = "";
		sb = new StringBuilder();

		for (int x = i; x >= 0; x--) {
			str1 += input.charAt(x);
		}
		for (int y = j; y >= i + 1; y--) {
			str2 += input.charAt(y);
		}
		for (int z = N - 1; z >= j + 1; z--) {
			str3 += input.charAt(z);
		}

		sb.append(str1).append(str2).append(str3);
		String word = sb.toString();
		arr[word.charAt(0) - 'a'].add(word);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}