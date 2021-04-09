package level2;

import java.util.ArrayList;


public class 프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        //숫자 클수록 중요도 높음
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : priorities)
            list.add(i);

        while (true){
            boolean flag = true;
            for (int k=1;k<list.size();k++){
                if(list.get(0)<list.get(k)){ //2번조건 뒤로가기
                    if(location==0) {  //요청한 문서가 제일 앞에 있을 때
                        location = list.size();
                    }
                    flag = false;
                    list.add(list.get(0));
                    list.remove(0);
                    break;
                }
            }
            location -= 1;

            if(flag){ //3번 조건
                list.remove(0);
                answer++;
                if(location == -1) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] p1 = {2,1,3,2};
        int [] p2 = {1,1,9,1,1,1};
        int [] p3 = {2,2,2,1,3,4};
        System.out.println(solution(p1,2));
        System.out.println(solution(p2,0));
        System.out.println(solution(p3,3));
    }
}
