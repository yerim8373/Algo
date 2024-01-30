package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L1_위험한효도 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int time = 0, last = 0;

		last = d % a;
		time = last == 0 ? (d/a * a) + last : (d/a * a) + (d/a * b) + last;

		last = d % b;
		time += last == 0 ? (d/b * b) + last : (d/b * a) + (d/b * b) + last;
		System.out.println(time);
	}
}
