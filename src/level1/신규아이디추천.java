package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        String answer = "-1";

        //1단계
        new_id = new_id.toLowerCase();

        char[] c = new_id.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (Character i : c)   list.add(i);

        int tmp = -2;
        //2단계
        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;
            //if ('a' <= list.get(i) && 'z' >= list.get(i) ) flag = true;
            if(Character.isLowerCase(list.get(i)) == true) flag = true;
            else if('1' <= list.get(i) && '9'>= list.get(i)) flag =true;
            else if('-' == list.get(i) || '_' == list.get(i)) flag = true;
            //3단계
            else if('.' == list.get(i)) {
                flag = true;

                //int tmp = -2;
                if( ++tmp == i) {
                    list.remove(i);
                    tmp = --i;
                }else tmp = i;
            }

            if(flag == false) {
                list.remove(i);
                i--;
            }
        }
        //4단계
        if(list.get(0)=='.') list.remove(0);
        if(list.get(list.size()-1)=='.') list.remove(list.size()-1);

        //6단계


        //5단계 빈문자열 a
        //if(list.get())

        for (Character i : list)
        System.out.print(i);
        //for (int i=0;i<new_id.length();i++)

        System.out.println();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        //bat.y.abcdefghi
    }
}
