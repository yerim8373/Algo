package programmers;

import java.util.Arrays;

public class L2_구명보트 {

	public static void main(String[] args) {
		

	}
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int min = 0;
        int max = people.length-1;
        
        // 최댓값을 줄여가면서 체크
        for (int i = people.length-1; i >= min; i--) {
			// 제한보다 작거나 같을 떄
        	if(people[min] + people[i] <= limit) {
				answer++;
				min++;
			} else { // 클 때
				answer++;
			}
		}
        
        return answer;
    }
}
