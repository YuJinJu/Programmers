package level1;

import java.util.ArrayList;

public class 삼진법_뒤집기 {

        public static int solution(int n) {
            int answer = 0;
            ArrayList<Integer> list = new ArrayList<>();

            while(n!=0){
                int x = n%3;
                n /=3;
                list.add(x);
            }

            for(int i=0;i<list.size();i++)
                answer += list.get(i) * Math.pow(3,list.size()-i-1);


            return answer;
        }
    public static void main(String[] args) {

        System.out.println( solution(45));
    }
}
