package level1;

import java.util.ArrayList;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        String answer = "";
        int tmp = -2;

        //1단계 소문자만
        new_id = new_id.toLowerCase();

        char[] c = new_id.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (Character i : c)   list.add(i);

        //2단계 소문자, 숫자, -, _, . 만
        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;

            //if ('a' <= list.get(i) && 'z' >= list.get(i) ) flag = true;
            if(Character.isLowerCase(list.get(i)) == true) flag = true;
            else if('0' <= list.get(i) && '9'>= list.get(i)) flag =true;
            else if('-' == list.get(i) || '_' == list.get(i)) flag = true;

            //3단계 중복된 . 제거
            else if('.' == list.get(i)) {
                flag = true;

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

        //4단계 처음과 끝이 . 이면 제거,
        if(list.get(0)=='.') list.remove(0);
        else if(list.get(list.size()-1)=='.') list.remove(list.size()-1);

        //5단계 빈문자열 a
        if(list.isEmpty()) list.add('a');

        //6단계 문자 15개만
        while (list.size()> 15) list.remove(list.size()-1);
        if(list.get(list.size()-1)=='.') list.remove(list.size()-1);

        //7단계
        while (list.size()<3) list.add(list.get(list.size()-1));

        for (Character i : list)
            answer += Character.toString(i);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
