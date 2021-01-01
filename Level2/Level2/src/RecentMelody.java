package src;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RecentMelody {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String m = sc.next();
		int size = sc.nextInt();
		String[] musicinfos = new String[size];
		for(int i = 0; i < size; i++) {
			musicinfos[i] = sc.next();
		}
		
		String answer = "(None)";
        int num = musicinfos.length;
        String[][] melody = new String[num][2];
        HashMap<String, String> replaceHash = new HashMap<>();
        replaceHash.put("A#", "a"); replaceHash.put("C#", "c");
        replaceHash.put("D#", "j"); replaceHash.put("F#", "k");
        replaceHash.put("G#", "g");
        
        for(int i = 0; i < num; i++){
            String[] target = musicinfos[i].split(",");
            String[] start = (target[0]).split(":"); String[] end = (target[1]).split(":");
            int pl = (Integer.parseInt(end[0])- Integer.parseInt(start[0]))*60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
            
            String origin = replaceMelody(target[3], replaceHash);
            melody[i][1] = playMelody(pl, origin);
            melody[i][0] = target[2];
        }
        m = replaceMelody(m, replaceHash);
        
        //길이 내림차순 sort
        Arrays.sort(melody, new Comparator<String[]>(){
            public int compare(String[] m1, String[] m2){
                return m2[1].length()-m1[1].length();
            }
        });
        //String 클래스의 contains!!
        for(int i = 0; i < num; i++){
            if(melody[i][1].contains(m)){
                answer = melody[i][0];
                break;
            }
        }
        System.out.println(answer);
	}
	
	public static String replaceMelody(String s, HashMap<String, String> replaceHash){
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                if(i < s.length()-1 && !Character.isAlphabetic(s.charAt(i+1))){
                    answer += replaceHash.get(s.substring(i, i+2));
                    i++;
                }else{
                    answer += Character.toString(c);
                }
            }
        }
        return answer;
    }
    
    public static String playMelody(int pl, String origin){
        String answer = "";
        int ol = origin.length();
        while(ol < pl){
            answer += origin;
            pl -= ol;
        }
        answer += origin.substring(0, pl);
        return answer;
    }
}
