package level1;

import java.util.ArrayList;

public class 포켓몬 {
    public static int solution(int [] nums) {
        int answer = 0;

        //중복제거
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums){
            if(!list.contains(i)) list.add(i);
        }

        if(list.size() >= nums.length/2) answer = nums.length/2;
        else answer = list.size();

        return answer;
    }

    public static void main(String[] args) {
        int [] n1 = {3,1,2,3};
        int [] n2 = {3,3,3,2,2,4};
        int [] n3 = {3,3,3,2,2,2};

        //2 3 2
        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
    }
}
