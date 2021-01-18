package src;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class LZWcompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		int[] answer = {};
        HashMap<String, Integer> dictionary = new HashMap<>();
        for(int i = 0; i < 26; i++){
            dictionary.put(Character.toString((char)('A' + i)), i+1);
        }
        answer = LZW(msg, dictionary);
        for(int i = 0; i < answer.length; i++) {
        	System.out.print(answer[i] + " ");
        }
	}
	
	public static int[] LZW(String msg, HashMap<String, Integer> dic){
        int start = 0; int end = start+1;
        int size = msg.length();
        int index = 27;
        ArrayList<Integer> printed = new ArrayList<>();
        while(start < size){
            for(end = start+1; end <= size; end++){
                if(dic.containsKey(msg.substring(start, end))){
                    continue;
                }
                else    break;
            }
            end--;
            printed.add(dic.get(msg.substring(start, end)));
            if(end < size)  dic.put(msg.substring(start, end+1), index++);
            start = end;
        }
        int asize = printed.size();
        int[] answer = new int[asize];
        for(int i = 0; i < asize; i++){
            answer[i] = printed.get(i);
        }
        return answer;
    }

}
