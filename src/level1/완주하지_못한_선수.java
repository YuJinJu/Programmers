package level1;

import java.util.Arrays;

public class 완주하지_못한_선수 {

    public static String solution(String [] participant, String[] completion){
        String answer = "";

        Arrays.sort(completion);
        Arrays.sort(participant);

        for (int i=0;i< completion.length;i++){
                if(!completion[i].equals(participant[i])){
                    return participant[i];
            }
        }
       answer = participant[participant.length-1];

        return answer;
    }

    public static void main(String [] args){
/*
participant         completion         return(완주못한선수)
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
"marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 */
        String [] participant1 = {"leo", "kiki", "eden"};
        String [] completion1 = {"eden", "kiki"};
        System.out.println( solution(participant1,completion1));

        String [] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String [] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println( solution(participant2,completion2));

        String [] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String [] completion3 = {"stanko", "ana", "mislav"};
        System.out.println( solution(participant3,completion3));

    }
}
