class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		for(int i = 1; i <= Math.sqrt(yellow); i++){
			if(yellow%i == 0){
				int c = yellow / i;
				int sum = (i * 2) + ((c + 2) * 2);
				if(sum == brown){
					answer[0] = c + 2;
					answer[1] = i + 2;
					break;
				}
			}
		}

		return answer;
	}
}