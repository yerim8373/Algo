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