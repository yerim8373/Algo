package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L3_여행경로 {
	static boolean[] visit;
	static String[] answer;

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}

	public static String[] solution(String[][] tickets) {
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

	private static void dfs(ArrayList<String> list, String str, String[][] tickets) {

		if(list.size() == tickets.length+1) {
			if(answer[0] == null) {
				answer = list.toArray(new String[0]);
				return;
			} else {
				for (int i = 0; i < answer.length; i++) {
					if(answer[i].charAt(0) > list.get(i).charAt(0)) {
						answer = list.toArray(new String[0]);
						return;
					} else if(answer[i].charAt(0) < list.get(i).charAt(0)) {
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
				System.out.println(" ------ " + list.toString());
				list.remove(list.size()-1);
				visit[i] = false;
			}
		}
	}
}
