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

        int [] lost = {2,4};
        int [] reserve = {1,3,5};
        System.out.println(solution(5,lost,reserve)); //5

        int [] lost1 = {1,2,3};
        int [] reserve1 = {2,3,4};
        System.out.println(solution(5,lost1,reserve1));//4

        int [] lost2 = {2,3,4};
        int [] reserve2 = {1,2,3};
        System.out.println(solution(5,lost2,reserve2));//4

        int [] lost3 = {3};
        int [] reserve3 = {1};
        System.out.println(solution(3,lost3,reserve3));//2

    }

}
