package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1_폰켓몬 {
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		int answer = 0;

		Set<Integer> checkNum = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!checkNum.contains(nums[i])){
				checkNum.add(nums[i]);
				answer++;
			}
		}

		if(answer > nums.length / 2){
			answer = nums.length / 2;
		}

		return answer;
	}
}
