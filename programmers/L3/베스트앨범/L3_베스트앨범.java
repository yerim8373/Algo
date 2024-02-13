package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L3_베스트앨범 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = solution(genres, plays);

		for (int i :
			answer) {
			System.out.println(i);
		}
	}

	private static int[] solution(String[] genres, int[] plays) {
		int[] answer;
		List<Integer> result = new ArrayList<>();

		// 장르, 재생 횟수 합
		Map<String, Integer> genresSum = new HashMap<>();
		// 장르, 노래 번호, 재생 횟수
		Map<String, Map<Integer, Integer>> music = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			// 장르 존재하면
			if(genresSum.containsKey(genres[i])){
				int cur = genresSum.get(genres[i]);
				genresSum.replace(genres[i], cur + plays[i]);
				music.get(genres[i]).put(i, plays[i]);
			} else {
				Map<Integer, Integer> tmp = new HashMap<>();
				tmp.put(i, plays[i]);
				music.put(genres[i], tmp);
				genresSum.put(genres[i], plays[i]);
			}
		}

		// 장르 별 재생 횟수 정렬
		List<String> keySet = new ArrayList<>(genresSum.keySet());
		Collections.sort(keySet, (s1, s2) -> Integer.compare(genresSum.get(s2), genresSum.get(s1)));

		// 장르별로 반복
		for (String genre : keySet) {
			Map<Integer, Integer> tmp = music.get(genre);
			List<Integer> musicPrior = new ArrayList<>(tmp.keySet());

			Collections.sort(musicPrior, (s1, s2) -> Integer.compare(tmp.get(s2), tmp.get(s1)));

			result.add(musicPrior.get(0));
			// 장르에 1개 이상 있으면 2개 넣어주기
			if(musicPrior.size() > 1){
				result.add(musicPrior.get(1));
			}
		}

		answer = result.stream().mapToInt(i -> i).toArray();

		return answer;
	}
}
