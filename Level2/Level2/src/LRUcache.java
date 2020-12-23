package src;

import java.util.*;

public class LRUcache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cacheSize = sc.nextInt();
		sc.nextLine();
		String[] cities = sc.nextLine().split(",");
		
		int answer = 0;
        HashMap<String, Integer> cache = new HashMap<>();
        for(int i = 0; i < cities.length; i++){
            String target = cities[i].toLowerCase();
            if(cache.containsKey(target)){
                cache.replace(target, i);
                answer++;
            }
            else{
                if(cache.size() == cacheSize) {
                    int min = Integer.MAX_VALUE; String minKey = "";
                    Iterator<String> itr = cache.keySet().iterator();
                    while(itr.hasNext()){
                        String next = itr.next();
                        if(cache.get(next) < min){
                            min = cache.get(next);
                            minKey = next;
                        }
                    }
                    cache.remove(minKey);
                }
                if(cacheSize > 0) cache.put(target, i);
                answer+=5;
            }
        }
        System.out.println(answer);
	}

}
