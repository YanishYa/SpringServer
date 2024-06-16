package com.example.SpringServer;

import java.util.LinkedList;
import java.util.List;

public class Results {
    List<KeyValuePair<String, Integer>> questionResultsList;
    List<Integer> resultsList;
    public Results(List<KeyValuePair<String, Integer>> questionResultsList){
        this.questionResultsList = questionResultsList;
        resultsList = new LinkedList<>();
        for (var item : questionResultsList){
            int i = -1;
            if (item.value % 5 == 0){
                i = 5;
            }
            else{
                i = item.value % 5;
            }
            resultsList.add(i);
        }
    }
    public String getJsonResults(){
        String json = "{";
        for (int i = 0; i < resultsList.size(); i++){
            json += "\"q" + i + "\": ";
            json += resultsList.get(i);
            if (i != resultsList.size() - 1){
                json += ",";
            }
        }
        json += "}";
        return json;
    }
    public static String getJsonResultsWithTarget(String results, String target){
        StringBuilder res = new StringBuilder();
        for (var ch : results.toCharArray()){
            if (ch != '}'){
                res.append(ch);
            }
        }
        res.append(",\"target\": " + target + "}]");
        return res.toString();
    }
}
