import java.util.*;
import java.io.*;

class Solution {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		answer[numbers.length-1] = -1;
		Stack<Integer> stk = new Stack<>();

		for(int i = 0; i < numbers.length; i++){
			// 맨위의 수보다 크면 빼서 answer 값 저장
			while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]){
				answer[stk.pop()] = numbers[i];
			}

			stk.push(i);
		}

		while(!stk.isEmpty()){
			answer[stk.pop()] = -1;
		}
		// for(int i = 0; i < numbers.length; i++){
		//     if(answer[i] == 0){
		//         answer[i] = -1;
		//     }
		// }

		return answer;
	}
}