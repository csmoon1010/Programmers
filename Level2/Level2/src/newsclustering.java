package src;
import java.util.*;
import java.util.Scanner;

public class newsclustering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        makeMap(str1, map1, set);
        makeMap(str2, map2, set);
        Iterator<String> itr = set.iterator();
        int num1 = 0; int num2 = 0;
        while(itr.hasNext()){
            String target = itr.next();
            int a = (map1.containsKey(target)) ? map1.get(target) : 0;
            int b = (map2.containsKey(target)) ? map2.get(target) : 0;
            num1 += Math.min(a, b);
            num2 += Math.max(a, b);
        }
        answer = (num1 == 0 && num2 == 0) ? 65536 : (int)((float)num1 / (float)num2 * 65536);
        System.out.println(answer);
	}
	
	public static void makeMap(String str, HashMap<String, Integer> map, HashSet<String> set){
        for(int i = 0; i < str.length()-1; i++){
            char target1 = str.charAt(i);
            char target2 = str.charAt(i+1);
            if(Character.isAlphabetic(target1) && Character.isAlphabetic(target2)){
                String key = str.substring(i, i+2).toLowerCase();
                if(!map.containsKey(key))  map.put(key, 1);
                else    map.replace(key, map.get(key) + 1);
                set.add(key);
            }
        }
    }
}
