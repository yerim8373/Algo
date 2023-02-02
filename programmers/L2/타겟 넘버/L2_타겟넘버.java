class Solution {
	int targ, answer;
	public int solution(int[] numbers, int target) {
		answer = 0;
		targ = target;
		// boolean[] visit = new boolean[numbers.length];

		dfs(0, 0, numbers);

		return answer;
	}

	private void dfs(int k, int sum, int[] numbers){
		if(k == numbers.length){
			if(sum == targ){
				answer++;
			}
			return;
		}
		dfs(k+1, sum+numbers[k], numbers);
		dfs(k+1, sum-numbers[k], numbers);
	}
}