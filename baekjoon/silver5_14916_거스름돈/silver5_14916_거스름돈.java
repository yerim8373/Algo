package BAEKJOON;

import java.io.*;

public class silver5_14916_거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		if(n%5 == 0) {
			result = n / 5;
		} else {
			if((n-((n/5)*5)) % 2 == 0) {
				result = n/5 + (n-((n/5)*5))/2;
			} else {
				result = (n/5-1) + (n-((n/5-1)*5))/2;
			}
		}
		if(n < 2 || n == 3) {
			result = -1;
		}
		
		System.out.println(result);
	}

}
