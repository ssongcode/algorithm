import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String endl = "\n";
    static String blank = " ";

    static int n;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException {
        String score;
        
        if (n >= 90)
            score = "A";
        else if (n >= 80)
            score = "B";
        else if (n >= 70)
            score = "C";
        else if (n >= 60)
            score = "D";
        else
            score = "F";

        System.out.print(score);
    }

    static void stk() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

}
