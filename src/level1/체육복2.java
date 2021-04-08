package level1;

public class 체육복2 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
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
