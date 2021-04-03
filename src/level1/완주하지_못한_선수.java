package level1;

public class 완주하지_못한_선수 {
    /*
  participant         completion         return(완주못한선수)
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav" (동명이인 가능)
     */

    public static String solution(String [] participant, String[] completion){
        String answer = "";
        for(int i=0;i<participant.length;i++){
            boolean flag = false;
            for(int j=0;j< completion.length; j++){
                if(!participant[i].contains(completion[j])) {
                    flag = true; //포함되어있지 않다.
                    break;
                }
            }
            if(flag == false) answer = participant[i];
        }


        return answer;
    }

    public static void main(String [] args){
/*
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
"marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 */
        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};
        System.out.println( solution(participant,completion));

    }
}
