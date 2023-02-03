class Solution {
	int answer = 0;
	int[][] dung;
	boolean[] visit;
	public int solution(int k, int[][] dungeons) {
		// int answer = 0;
		dung = dungeons;
		visit = new boolean[dungeons.length];

		dfs(k, 0);

		return answer;
	}

	private void dfs(int hp, int cnt){

		answer = Math.max(answer, cnt);
		for(int i = 0; i < visit.length; i++){
			if(!visit[i]){
				if(hp >= dung[i][0]){
					visit[i] = true;
					dfs(hp-dung[i][1], cnt+1);
					visit[i] = false;
				}
			}
		}
	}
}