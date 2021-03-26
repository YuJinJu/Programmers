package level1;

public class collatz {
    public static int solution(int num) {
        int answer = 0;
        long n = (long)num;
        while(n!=1){
            if(n%2 == 0) n/=2;
            else  n = n*3 + 1;

            if(answer>=500) return -1;
            answer++;
        }

        return answer;
    }

    public static void main(String [] args){
        System.out.print(solution(6));
    }
}
