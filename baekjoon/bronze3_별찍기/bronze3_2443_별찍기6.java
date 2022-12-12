package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze3_2443_별찍기6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < N-i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < N-i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
