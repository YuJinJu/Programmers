package level1;

import java.util.Arrays;

public class 체육복 {

        public static int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int yes = n - lost.length; //빌리지 않고 체육할 수 있는 학생수
            int lend = 0; //빌려준 학생수

            int cnt=0;
            int length = lost.length;
            if(lost.length>reserve.length) length = reserve.length;

            //내가 내꺼 입을 때
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    if( reserve[i] == lost[j] ) {
                        reserve[i] = -1;
                        lost[j] =-99;
                        cnt++;
                        break;
                    }
                }
            }

            //앞뒤의 숫자 비교를 위해 정렬
            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i =0;i<reserve.length;i++){
                for(int j=lend;j<lost.length;j++){
                    if( reserve[i]-1 == lost[j] || reserve[i]+1 == lost[j]) {
                        lend++;
                        //System.out.println("reserve"+ reserve[i]);
                        //System.out.println("lost"+ lost[j]);
                        break;
                    }
                }
            }

            answer = yes + lend+ cnt;
            return answer;
        }

    public static void main(String[] args) {

    }

}
