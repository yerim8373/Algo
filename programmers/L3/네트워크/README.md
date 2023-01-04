# 📘 네트워크

## 풀이 방법
- n개만큼 방문배열 만든 후, 0부터 dfs 탐색

## Code

```java
import java.util.*;
class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] visit = new boolean[computers.length];

		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]) {
				answer++;
				dfs(computers, i, visit);
			}
		}

		return answer;
	}

	private void dfs(int[][] computers, int i, boolean[] visit) {
		visit[i] = true;

		for (int j = 0; j < visit.length; j++) {
			if(j!=i && computers[i][j] == 1 && !visit[j]) {
				dfs(computers, j, visit);
			}
		}
	}
}

```