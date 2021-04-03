package level1;
import java.util.*;

public class 비밀지도 {
        public static String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = {};
            //비트연산자?
            //하나라도 1이 있으면 1
            //둘다 0이면 0
        /*
        1 0  1
        0 1  1
        0 0  0
        1 1  1
        */

            Stack<String> stack = new Stack<>();
            //Stack<Integer> stack2 = new Stack<>();

            String [] a1 = new String[n];
            String [] a2 = new String[n];

            for(int i=0;i<n;i++){ //한줄씩
                //지도1
                for(int j=0;j<n;j++){// 10010
                    stack.push(String.valueOf(arr1[i]%2)); //거꾸로
                    arr1[i]/=2;
                }
                a1[i] = stack.pop();
                //for(int j=1;j<stack.size();j++) a1[i] += stack.pop();   //이진법 01001
                while(!stack.isEmpty()) a1[i] += stack.pop();   //이진법   01001

                //지도2
                for(int j=0;j<n;j++){    //01111
                    stack.push(String.valueOf(arr2[i]%2));
                    arr2[i]/=2;
                }
                a2[i] = stack.pop();
                //for(int j=0;j<stack.size() ;j++) a2[i] += stack.pop();   //이진법  11110
                while(!stack.isEmpty()) a2[i] += stack.pop();   //이진법   11110
            }

            String [] tmp = new String[n];
            answer = new String[n];

            for(int k=0;k<n;k++){
                tmp[k] = String.valueOf(Integer.parseInt(a1[k]) | Integer.valueOf(a2[k]));
                for(int l=0;l<tmp[k].length();l++){
                    if(tmp[k].charAt(l)=='1') answer[k] += "#";
                    else answer[k] +=" ";
                }
            }
            return answer;
        }
    
    public static void main(String[] args) {
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        //출력	["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(solution(n,arr1,arr2));
    }
}
