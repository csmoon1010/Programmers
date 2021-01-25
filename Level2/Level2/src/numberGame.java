package src;
import java.util.Scanner;
import java.util.Stack;

public class numberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		String answer = "";
        String[] allList = getAll(n, t*m);
        for(int i = 0; i < t; i++){
            answer += allList[i*m+p-1];
        }
        System.out.println(answer);
	}
	
	public static String[] getAll(int n, int size){
        String[] list = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String[] answer = new String[size];
        int index = 0; int number = 0;
        while(index < size){
            Stack<String> stack = new Stack<>();
            int temp = number;
            while(temp >= n){
                stack.push(list[temp%n]);
                temp = temp/n;
            }
            stack.push(list[temp]);
            while(!stack.empty() && index < size)   answer[index++] = stack.pop();
            number++;
        }
        return answer;
    }
}
