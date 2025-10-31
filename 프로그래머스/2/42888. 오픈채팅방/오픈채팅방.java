import java.awt.*;
import java.util.*;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
            List<String> answer = new ArrayList<>();
            StringTokenizer st;
            Map<String, String> hashMap = new HashMap<>();

            for (int i=0; i<record.length; i++){
                st = new StringTokenizer(record[i]);
                String sta = st.nextToken();
                if(sta.equals("Leave")) continue;
                hashMap.put(st.nextToken(), st.nextToken());
            }

            for(String str : record){
                st = new StringTokenizer(str);
                String status = st.nextToken();
                String name = hashMap.get(st.nextToken());
                if(status.equals("Enter")){
                    answer.add(name+"님이 들어왔습니다.");
                } else if (status.equals("Leave")) {
                    answer.add(name+"님이 나갔습니다.");
                }
            }
            return answer.toArray(new String[0]);
    }
}