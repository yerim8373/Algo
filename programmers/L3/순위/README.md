# 📘 순위

## 풀이 방법
- 처음에 List<List<Integer>>로 그래프 연결해서 연결된 개수 카운트해서 하려고 했음
- 5, [[3, 5], [4, 2], [4, 5], [5, 1], [5, 2]] => 이 경우 안됨
- 찾아본 결과 플로이드-워샬
- **플로이드 워셜의 핵심 아이디어**

**'거쳐가는 정점'을 기준으로 최단거리를 구하는 것.**
a->b 일 때, b->c 라면 a->c 라는 점

- 플로이드 워샬로 정점 배열 채우고, 조건 만족한 개수가 n-1개면 answer++
- 한번 더 봐야할듯...!

## Code

```java
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

```