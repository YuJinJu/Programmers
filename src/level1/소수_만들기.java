package level1;

import java.util.ArrayList;
import java.util.Collections;

public class 소수_만들기 {
    public static int solution(int[] nums) {
        int answer = 0;
        ArrayList <Integer> list = new ArrayList<>();

        for (int i =0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    //arr[count++] = nums[i] + nums[j] + nums[k]; //세 수의 합
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        Collections.sort(list);

        //에라토스테네스의 체를 하기위해 2~n까지 저장
        int [] arr = new int[3001];
        int n = list.get(list.size()-1);
        for(int i=2;i<=n;i++) arr[i] = i;

        //2~n까지 지우지 않은 값은 소수
        for(int i=2;i<=n;i++) {
            if(arr[i] != 0 ) {
                if(list.contains(arr[i])) answer ++;
                //지우지 않은 값의 배수들을 지워줘서 소수가 아님을 판단.
                for(int j=1;i*j<=n;j++) arr[i*j]=0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] n = {1,2,3,4};
        int [] n2 = {1,2,7,6,4};

        System.out.println(solution(n)); //1
        System.out.println(solution(n2)); //4
    }
}
