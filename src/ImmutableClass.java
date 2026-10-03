import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

    // Решил использовать коллекции по примеру из дополнительного материала,
    // так как с ними в принципе удобно и приятно работать
    private Map<String, String> fieldMap;

    public ImmutableClass(Map<String, String> fieldMap) {
        Map<String, String> mapCopy = new HashMap<String, String>();
        for(String key : fieldMap.keySet()) {
            mapCopy.put(key, fieldMap.get(key));
        }
        this.fieldMap = mapCopy;
    }

    public Map<String, String> getFieldMap() {
        Map<String, String> mapCopy = new HashMap<String,String>();
        for(String key : fieldMap.keySet()) {
            mapCopy.put(key, fieldMap.get(key));
        }
        return mapCopy;
    }

    // Поле с изменяемым классом
    public static class InnerClass {
        public String accessibleString;

        public InnerClass (String accessibleString) {
            this.accessibleString = accessibleString;
        };

        public String getAccessibleString() {
            return accessibleString;
        }
    }
}
