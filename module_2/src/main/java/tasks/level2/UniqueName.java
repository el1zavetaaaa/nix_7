package tasks.level2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniqueName {


    public static String findFirstUnique(List<String> names) {
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String name : names) {
            counts.compute(name, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }


}
