package programmers;

import java.util.*;

public class L2_최솟값만들기 {

	public static void main(String[] args) {
		int[] A = {1,2};
		int[] B = {3,4};
		System.out.println(solution(A, B));
	}
	
	public static int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < B.length; i++) {
			answer += A[i] * B[B.length-1-i];
		}

        return answer;
    }
}
