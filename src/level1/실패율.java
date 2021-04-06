package level1;

import java.util.Arrays;

public class 실패율 {
    public static int [] solution(int N, int [] stages){
        int [] answer = new int[N];
        Arrays.sort(stages);
        int tmp = 0;

        //1   2      3    4 5
        //1 / 2 2 2 /3 3 /4/ /<= n
        // 1/8, 3/7, 2/4, 1/2, 0/1
        float [] rate = new float[N];
        for (int i=1;i<=N;i++){
            int count = 0;
            for (int j=tmp;j<stages.length;j++) {
                if (i == stages[j]) count++;
                else break;
            }
            rate[i-1] = (float)count/(float)(stages.length-tmp);
            tmp += count;
        }
        float [] arr = new float[N];
        int size = 0;
        for (float i : rate) arr[size++] = i;
        Arrays.sort(arr);

        for (int i= arr.length-1;i>=0;i--){  //4 3 2 1 0
            for (int j=0;j<rate.length;j++){ //0 1 2 3 4
                if(arr[i] == rate[j]) {
                    answer[arr.length-1-i] = j+1;
                    rate[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int [] s= {2,1,2,6,2,4,3,3};
        int [] s1= {4,4,4,4,4};
        System.out.println(solution(5,s));
        System.out.println(solution(4,s1));
    }
}
