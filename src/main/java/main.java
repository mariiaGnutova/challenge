import org.json.JSONException;

import java.util.ArrayList;
import java.util.Map;

public class main {
    public static void main(String[] args) throws JSONException {
        String jsonObject = "{\"food\": [\"bread\", \"noodle\", \"rice\", \"chips\"], \"number\": [1, 2], \"drink\": [\"cola\", \"juice\"]}";

        Transformation transformation = new Transformation(jsonObject);
        Map<String, ArrayList<String>> mapResult = (Map<String, ArrayList<String>>) transformation.toMap();

        transformation.deleteElementsWithNum(mapResult);
        System.out.println("Sorted key: " + transformation.sortKey(mapResult));
        transformation.deleteElementsConsistMoreThenTwoValues(mapResult);
    }
}
