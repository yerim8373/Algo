import java.util.*;

class Solution {
	boolean[][] visit;

	public int solution(int n, int[][] results) {
		int answer = 0;
		visit = new boolean[n+1][n+1];

		for(int i = 0; i < results.length; i++){
			visit[results[i][0]][results[i][1]] = true;
		}

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				for(int k = 1; k <= n; k++){
					if(visit[j][i] && visit[i][k]){
						visit[j][k] = true;
					}
				}
			}
		}

		for(int i = 1; i <= n; i++){
			int cnt = 0;
			for(int j = 1; j <= n; j++){
				if(visit[i][j] || visit[j][i]){
					cnt++;
				}
			}
			if(cnt == n-1){
				answer++;
			}
		}

		return answer;
	}
}