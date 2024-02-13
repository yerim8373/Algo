# 📘 베스트앨범

## 풀이 방법
1. 장르 별 재생 횟수 합을 HashMap에 넣어 계산해준다.
2. 동시에 장르, 노래 번호, 재생 횟수를 HashMap<String, HashMap<Integer, Integer>>에 넣어준다.
3. 장르 별 재생 횟수를 정렬해준다. 
   - List<String> keySet = new ArrayList<>(genresSum.keySet());
   - Collections.sort(keySet, (s1, s2) -> Integer.compare(genresSum.get(s2), genresSum.get(s1)));
4. 장르 우선순위를 반복하며 music을 정렬해준다.
   - Collections.sort(musicPrior, (s1, s2) -> Integer.compare(tmp.get(s2), tmp.get(s1)));
5. 정렬된 music 하나를 List<Integer>에 넣어주고, 장르에 music이 2개 이상이면 하나 더 넣어준다.
6. List<Integer>로 정렬되어있는 노래 순서를 int[]로 바꿔준다.
   - answer = result.stream().mapToInt(i -> i).toArray();
- ** stream을 잘 활용하자 ❕ **

## Code

```java
import java.util.*;
import java.io.*;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
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
```