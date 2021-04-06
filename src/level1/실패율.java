package level1;

import java.util.Arrays;

public class 실패율 {
    public static int [] solution(int N, int [] stages){
        int [] answer = new int[N];
        Arrays.sort(stages);
        int tmp = 0;

        //1   2      3    4 5
        // 1 , 2 2 2 ,3 3 ,4,  <= n
        // 1/8, 3/7, 2/4, 1/2, 0/1

        float [] rate = new float[N];

        for (int i=1;i<=N;i++){
            int count = 0;
            for (int j=tmp;j<stages.length;j++) {
                if (i == stages[j]) count++;
                else break;
            }
            rate[i-1] = (float)count/(float)(stages.length-tmp);
            if(stages.length<=tmp) rate[i-1] = 0;
            tmp += count;
        }


        //실패율 높은순으로 정렬
        float [] arr = new float[N];
        int size = 0;
        for (float i : rate) arr[size++] = i;
        Arrays.sort(arr);

        //실패율 높은순으로 스테이지
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
        int [] s1= {1,2,2,1,3}; // ❗
        int [] s2= {1,2,3,4,5};
        int [] s3= {2,1,2,6,2,4,3,3};
        int [] s4= {4,4,4,4,4};

        for (int k : solution(5,s1))
            System.out.print(k+" ");
        System.out.println(); //3 2 1 4 5

        for (int k : solution(6,s2))
            System.out.print(k+" ");
        System.out.println(); //5 4 3 2 1 6

        for (int k : solution(5,s3))
            System.out.print(k+" ");
        System.out.println(); //3 4 2 1 5

        for (int k : solution(4,s4))
            System.out.print(k+" "); //4 1 2 3
    }
}
