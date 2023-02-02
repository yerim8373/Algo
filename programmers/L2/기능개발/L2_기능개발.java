import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<>();
		int min=0;
		for(int i = 0; i < speeds.length; i++){
			int n = 100-progresses[i];
			if(n%speeds[i]==0){
				n = n/speeds[i];
			} else{
				n = n/speeds[i] + 1;
			}

			// if(i==0){
			//     min = n;
			//     queue.offer(1);
			//     continue;
			// }

			if(min >= n){
				stack.add(stack.pop()+1);
				min = Math.max(min, n);
			} else {
				stack.add(1);
				min = n;
			}
		}

		int[] answer = new int[stack.size()];
		for(int i = stack.size()-1; i > -1; i--){
			answer[i] = stack.pop();
		}

		return answer;
	}
}