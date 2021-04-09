package level2;

import java.util.ArrayList;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int [] day = new int[progresses.length];

        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0) day[i] = (100-progresses[i])/speeds[i];
            else day[i] = (100-progresses[i])/speeds[i] + 1;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int cnt = 1;
        int sum = day[0];
        for(int j=1;j<day.length;j++){

            if(sum<day[j]) {
                arr.add(cnt);
                cnt = 1;
                sum = day[j];
            }
            else cnt++;
        }
        arr.add(cnt);

        int size = 0;
        answer = new int[arr.size()];
        for(int k : arr)
            answer[size++] = k;

        return answer;
    }

    public static void main(String[] args) {
        int [] p = {93,30,55};
        int [] p2 = {95,90,99,99,80,99};

        int [] sp = {1,30,5};
        int [] sp2 = {1,1,1,1,1,1};

        for(int i : solution(p,sp))
        System.out.print(i+" ");
        System.out.println();

        for(int i : solution(p2,sp2))
        System.out.print(i+" ");
    }
}
