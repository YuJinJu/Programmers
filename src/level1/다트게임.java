package level1;

public class 다트게임 {
    /*
     점수 : int 0~10
     보너스 : s 1제곱, d 2제곱, t 3제곱 / 점수마다 하나씩 존재

     옵션 : * #
     * 지금점수와 직전 점수 두배 / 처음에 * 이면 첫번째 점수 두배 / 중첩되면 4배 / # 와 중첩되면  -2배 / 존재 안할 수 있음
     # 지금점수 -1배


ex1)	1S 2D * 3T	    1의 1제곱 + 2의 2제곱 지금점수와 직전점수 두배 + 3의 세제곱 = 37
ex2)	1D 2S # 10S	    1의 2제곱 + 2의 1제곱 지금!점수 -1배 + 10의 1제곱 = 9
ex3)	1D 2S 0T	    1의 2제곱 + 2의 1제곱 + 0의 세제곱 = 3
ex4)	1S * 2T * 3S	    1의 1제곱 두배 + 2의 3제곱 지금점수와 직전점수 2배 + 3의 1제곱 = 23
ex5)	1D # 2S * 3S	    1의 제곱 -1배 + 2의 1제곱 지금점수와 직전점수 2배 + 3의 1제곱 = 5
ex6)	1T 2D 3D #	-4
ex7)	1D 2S 3T *	59
     */
    public static int solution(String dartResult) {
        int answer = 0;
        int score = 0;

        double [] arr = new double[dartResult.length()];
        //ArrayList<Double> list = new ArrayList<>();
        int cnt = 0;

        for(int i=0;i<dartResult.length();i++){
            int option = 0;

            char  c = dartResult.charAt(i);

            //숫자 일 때
            if(c>='0' && c<='9'){ //또는 isDigit()

                if(score == 1 && c=='0') { //10일때
                    score = 10;
                    continue;
                }
                score = c - '0'; //char -> int 변환 // 또는 Character.getNumericValue()
                continue;
            }

            //bonus 제곱
            if(c=='S')     arr[cnt] = Math.pow(score,1);
            else if(c=='D')     arr[cnt] = Math.pow(score,2);
            else if(c=='T')    arr[cnt] = Math.pow(score,3);

            //option
             else if(c=='*'){ //2배
                option = 2;
                cnt--;
            }
            else if(c=='#') { //-1배
                option = -1;
                cnt--;
            }


            //옵션 있을때
            if(option!=0){
                if(cnt!=0 && option==2){
                    arr[cnt-1] *= option;
                }
                arr[cnt] *= option; //첫번째에 옵션 있을때
            }

            cnt++;
        }
        for(double k : arr) answer+=k;

        return answer;
    }

    public static void main(String[] args) {
        String [] s = {"1S2D*3T","1D2S#10S","1D2S0T","1S*2T*3S","1D#2S*3S","1T2D3D#","1D2S3T*"};
        /*
1   1S2D*3T	37	11 * 2 + 22 * 2 + 33
2	1D2S#10S	9	12 + 21 * (-1) + 101
3	1D2S0T	3	12 + 21 + 03
4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
6	1T2D3D#	-4	13 + 22 + 32 * (-1)
7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
         */

        for(String k : s)
        System.out.println(solution(k));

    }
}
