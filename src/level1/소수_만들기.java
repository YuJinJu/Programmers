package level1;

import java.util.ArrayList;

public class 소수_만들기 {

    public static int solution(int[] nums) {
        int answer = -1;
        //같은 결과 여러가지 방법 중복허용

        ArrayList<Integer> n = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    n.add(nums[i]+nums[j]+nums[k]);
                    //System.out.print(nums[i]+nums[j]+nums[k]+" ");
                }
            }
        }

        //n[i]가 소수인지 판별
        int cnt = 0;
        for(int i=0;i<n.size();i++){
            boolean flag = true;

            for(int j=2;j<=Math.sqrt(n.get(i));j++){
                if(n.get(i)%j==0) flag = false;
            }
            if(flag == true) cnt++;
        }

        answer = cnt;
        return answer;
    }


    public static void main(String[] args) {
        int [] n = {1,2,3,4};
        int [] n2 = {1,2,7,6,4};

        System.out.println(solution(n)); //1
        System.out.println(solution(n2)); //4
    }
}
