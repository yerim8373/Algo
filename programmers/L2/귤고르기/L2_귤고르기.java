package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class L2_귤고르기 {
	static Map<Integer, Integer> tang = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		int[] t = {1, 3, 2, 5, 4, 5, 2, 3};
		System.out.println(solution(6, t));
	}

	public static int solution(int k, int[] tangerine) {
		int answer = 0;


		for (int i = 0; i < tangerine.length; i++) {
			int key = tangerine[i];
			if(tang.get(key) != null) {
				tang.replace(key, tang.get(key)+1);
			} else {
				tang.put(key, 1);
			}
		}

		// 개수 기준으로 정렬
		List<Integer> list = new ArrayList<>(tang.keySet());
		list.sort((o1, o2) -> tang.get(o2).compareTo(tang.get(o1)));

		while(k>0) {
			k -= tang.get(list.remove(0));
			answer++;
		}

		return answer;
	}

//	public static class customComparator implements Comparator<Integer>{
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return tang.get(o2).compareTo(tang.get(o1));
//		}
//
//	}
}