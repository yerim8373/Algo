package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class L2_바이러스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			K = (K*P)%1000000007;
		}
		System.out.println(K);
	}

}
