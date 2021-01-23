package src;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		String[] files = new String[size];
		for(int i= 0; i < size; i++) {
			files[i] = sc.nextLine();
		}
		String[] answer = new String[files.length];
        String[][] sfiles = splitName(files, size);
        Arrays.sort(sfiles, new Comparator<String[]>(){
            public int compare(String[] s1, String[] s2){
                int answer = 0;
                String h1 = s1[0].toLowerCase(); String h2 = s2[0].toLowerCase();
                if(!h1.equals(h2))  answer = h1.compareTo(h2);
                else{
                    int n1 = Integer.parseInt(s1[1]);
                    int n2 = Integer.parseInt(s2[1]);
                    answer = n1-n2;
                }
                return answer;
            }
        });
        for(int i = 0; i < size; i++){
            answer[i] = sfiles[i][0] + sfiles[i][1] + sfiles[i][2];
            System.out.print(answer[i] + " ");
        }
	}

	public static String[][] splitName(String[] files, int size){
        String[][] answer = new String[size][3];
        for(int i= 0; i < size; i++){
            int nameL = files[i].length();
            int h = 0; int n = 0;
            for(h = 0; h < nameL; h++){
                if(Character.isDigit(files[i].charAt(h)))  break;
            }
            for(n = h; n < h+5 && n < nameL; n++){ //예외 CASE 생각 또 못함
                if(!Character.isDigit(files[i].charAt(n))) break;
            }
            answer[i][0] = files[i].substring(0, h);
            answer[i][1] = files[i].substring(h, n);
            answer[i][2] = files[i].substring(n, nameL);
        }
        return answer;
    }
}
