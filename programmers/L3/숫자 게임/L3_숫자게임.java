package programmers;

import java.util.Arrays;

public class L3_숫자게임 {
	//	static boolean[] visit;

	public static void main(String[] args) {
		int[] A = {5, 1, 3, 7};
		int[] B = {2,2,6,8};
		System.out.println(solution(A, B));
	}
	public static int solution(int[] A, int[] B) {
		int answer = 0;
		//        visit = new boolean[A.length];

		Arrays.sort(A);
		Arrays.sort(B);

		int a = B.length-1;
		for (int i = B.length-1; i >= 0; i--) {
			if(A[i] < B[a]) {
				answer++;
				a--;
			}
		}

		return answer;
	}
}
