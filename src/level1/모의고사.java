package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public static int[] solution(int[] answers) {
        int[] ans = {};
        int case1= 0;
        int case2 = 0;
        int case3 = 0;

        int cnt1= 0;
        int cnt2=0;
        int cnt3=0;

        for(int i=0;i<answers.length;i++){
            case1 = i%5 +1;

            if(i%2==0) case2 = 2;
            else if(i%8 == 1) case2 = 1;
            else if(i%8 == 3) case2 = 3;
            else if(i%8 == 5) case2 = 4;
            else if(i%8 == 7) case2 = 5;

            if(i%10==0||i%10==1) case3 = 3;
            else if(i%10==2||i%10==3) case3 = 1;
            else if(i%10==4||i%10==5) case3 = 2;
            else if(i%10==6||i%10==7) case3 = 4;
            else if(i%10==8||i%10==9) case3 = 5;

            if(answers[i] == case1) cnt1++;
            if(answers[i] == case2) cnt2++;
            if(answers[i] == case3) cnt3++;
        }
        ArrayList<Integer> list = new ArrayList<>();

        if(cnt1 == cnt2 && cnt2 == cnt3) {
            ans = new int[3];
            ans[0]= 1;
            ans[1]= 2;
            ans[2]= 3;
        }
        else {
            int m = Math.max(Math.max(cnt1,cnt2),cnt3);

            if(cnt1 == m)  list.add(1);
            if(cnt2 == m) list.add(2);
            if(cnt3 == m) list.add(3);

            int size = 0;
            ans = new int[list.size()];
            for (int i : list) ans[size++] = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] a= {1,2,3,4,5};
        int [] b= {1,3,2,4,2};

        for (int x : solution(a))
            System.out.print(x+ " "); //1

        for (int x : solution(b))
            System.out.print(x); //1 2 3
    }
}

