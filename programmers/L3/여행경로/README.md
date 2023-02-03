# 📘 여행경로

## 풀이 방법
- "ICN"으로 시작해서 dfs 탐색
- 리스트에 담아서 탐색하고 다 탐색하면 알파벳 순서 비교
- 테스트케이스 1번에서 막힘ㅠㅠ
---
- 전에 탐색 후 문자열 비교할 때 charAt으로 첫글자만 비교함
- answer[i].compareTo(list.get(i))로 비교해서 양수이면 list에 있는 값이 더 작은거니까 다시 담아주고
- 음수면 걍 answer 그대로

## Code

```java
import java.util.*;

class Solution {
	boolean[] visit;
	String[] answer;

	public String[] solution(String[][] tickets) {
		answer = new String[tickets.length+1];
		visit = new boolean[tickets.length];

		for (int i = 0; i < tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(tickets[i][0]);
				list.add(tickets[i][1]);
				visit[i] = true;
				dfs(list, tickets[i][1], tickets);
				visit[i] = false;
			}
		}
		return answer;
	}

	private void dfs(ArrayList<String> list, String str, String[][] tickets) {

		if(list.size() == tickets.length+1) {
			if(answer[0] == null) {
				answer = list.toArray(new String[0]);
				return;
			} else {
				for (int i = 0; i < answer.length; i++) {
					if(answer[i].compareTo(list.get(i)) > 0) {
						answer = list.toArray(new String[0]);
					} else if(answer[i].compareTo(list.get(i)) < 0) {
						return;
					}
				}
				return;
			}
		}

		for (int i = 0; i < visit.length; i++) {
			if(!visit[i] && tickets[i][0].equals(str)) {
				list.add(tickets[i][1]);
				visit[i] = true;
				dfs(list, tickets[i][1], tickets);
				//				System.out.println(" ------ " + list.toString());
				list.remove(list.size()-1);
				visit[i] = false;
			}
		}
		return;
	}
}

```