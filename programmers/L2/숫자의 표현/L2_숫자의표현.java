class Solution {
	public int solution(int n) {
		int answer = 0;
		for(int i = n; i > 0; i--){
			int sum = 0;
			for(int j = i; j > 0; j--){
				sum += j;
				if(sum == n){
					answer++;
					break;
				} else if(sum > n){
					break;
				}
			}
		}

		return answer;
	}
}