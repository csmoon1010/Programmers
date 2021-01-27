package src;
import java.util.*;

public class menuRenewal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int oSize = sc.nextInt();
		sc.nextLine();
		String[] orders = new String[oSize];
		for(int i = 0; i < oSize; i++)	orders[i] = sc.nextLine();
		
		int cSize = sc.nextInt();
		sc.nextLine();
		int[] course = new int[cSize];
		for(int i = 0; i < cSize; i++)	course[i] = sc.nextInt();
		
		String[] answer;
        ArrayList<String> answerList = new ArrayList<>();
        
        int size = course.length;
        int limit = course[size-1];
        ArrayList<String[]> list = new ArrayList<>();
        
        for(int i = 1; i <= limit; i++){
            HashMap<String, Integer> hash = new HashMap<>();
            for(int j = 0; j < orders.length; j++){
                HashSet<String> set = new HashSet<>();
                if(i > 1){
                    String[] cand = list.get(i-2);
                    for(int k = 0; k < cand.length; k++){
                        boolean flag = true;
                        for(int l = 0; l < cand[k].length(); l++){
                            if(!orders[j].contains(cand[k].substring(l, l+1))){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)    addOne(orders[j], set, cand[k]);
                    }
                }
                else    addOne(orders[j], set, "");
                Iterator<String> setitr = set.iterator();
                while(setitr.hasNext()){
                    String target = setitr.next();
                    if(hash.containsKey(target))   hash.replace(target, hash.get(target)+1);
                    else    hash.put(target, 1);
                }
            }
            
            Iterator<String> itr = hash.keySet().iterator();
            ArrayList<String> temp = new ArrayList<>();
            int max = 2;
            while(itr.hasNext()){
                String target = itr.next();
                if(hash.get(target) > 1)    temp.add(target);
                if(hash.get(target) > max)    max = hash.get(target);
            }
            String[] result = new String[temp.size()];
            for(int j = 0; j < result.length; j++){
                result[j] = temp.get(j);
            }
            System.out.println();
            list.add(result);
            
            itr = hash.keySet().iterator();
            while(itr.hasNext()){
                String target = itr.next();
                if(hash.get(target) == max) answerList.add(target);
            }
        }
        
        ArrayList<String> answerList2 = new ArrayList<>();
        for(int i = 0; i < answerList.size(); i++){
            for(int j = 0; j < course.length; j++){
                if(answerList.get(i).length() == course[j]) answerList2.add(answerList.get(i));
            }
        }
        answer = new String[answerList2.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList2.get(i);
        }
        Arrays.sort(answer);
        
        for(int i= 0; i < answer.length; i++) {
        	System.out.print(answer[i] + " ");
        }
	}
	
	public static void addOne(String s, HashSet<String> set, String base){
        for(int i = 0; i < s.length(); i++){
            String target = s.substring(i, i+1);
            if(base.contains(target))    continue;
            else{
                String str = sortString(base + target);
                set.add(str);
            }
        }
    }
    
    public static String sortString(String s){
        String answer = "";
        char[] str = s.toCharArray();
        Arrays.sort(str);
        for(int i = 0; i < str.length; i++) answer += str[i];
        return answer;
    }

}
