import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] score;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		score = new int[N];
		stk();
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(score[i], max);
		}
	}

	static void pro() throws IOException {
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (score[i] / (double)(max) * 100);
		}
		
		System.out.println(sum / N);
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}