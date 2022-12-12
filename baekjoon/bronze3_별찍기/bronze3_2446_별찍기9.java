package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze3_2446_별찍기9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (N-1-i)*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-2-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*(i+1)+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
