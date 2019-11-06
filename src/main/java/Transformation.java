import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;

public class Transformation {

    public  String stringForParsing;


    public Transformation(String stringForParsing) {
        this.stringForParsing = stringForParsing;
    }

    public Map<String, ArrayList<String>> toMap() throws JSONException {

        JSONObject jsonObj = new JSONObject(stringForParsing);
        Map<String, ArrayList<String>> map = new Gson().fromJson(jsonObj.toString(),Map.class);
        System.out.println(map);

        return map;
    }

    public void deleteElementsWithNum(Map<String,ArrayList<String>> originalMap){

        Map<String,ArrayList<String>> toChange = cloneMap(originalMap);
        Iterator<Map.Entry<String, ArrayList<String>>> it = toChange.entrySet().iterator();
        while (it.hasNext()) {
           Map.Entry<String, ArrayList<String>> pair = it.next();
           if(ifNumber(pair.getValue())){
                it.remove();
            }
        }

        System.out.println("Map without numbers" + toChange);

    }

    public List sortKey (Map<String,ArrayList<String>> toChange){
        List<String> sortedKeys = new ArrayList<>(toChange.keySet());
        Collections.sort(sortedKeys);
        return sortedKeys;
    }

    public void deleteElementsConsistMoreThenTwoValues(Map<String,ArrayList<String>> originalMap){
        Map<String,ArrayList<String>> toChange = cloneMap(originalMap);

        Iterator<Map.Entry<String, ArrayList<String>>> it = toChange.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = it.next();
            if(!(pair.getValue().size()>2)){
                it.remove();
            }
        }

        System.out.println("delete Elements Consist More Then Two Values" + toChange);

    }

    public boolean ifNumber(Object object)
    {
        String obj = object.toString();
        if(obj.split("\\d").length>1){
           return true;
        }
        return false;
    }

    public Map<String,ArrayList<String>> cloneMap(Map<String,ArrayList<String>> originalMap){
        Map<String,ArrayList<String>> clone = new HashMap<>();

        for (Map.Entry<String,ArrayList<String>> entry: originalMap.entrySet()) {
            clone.put(entry.getKey(), entry.getValue());
        }
        return clone;
    }
}
