import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key needed", "valid value");

        // Создание объекта иммутабельного класса и вывод его содержимого
        ImmutableClass imObject = new ImmutableClass(map);
        System.out.println("Before attempt to change:" + (char) '\n' + "source map size: " + map.size());
        imObject.getFieldMap().keySet().forEach(key -> System.out.println(key + ", " +
                imObject.getFieldMap().get(key)));

        // Создание контрольной копии коллекции для проверки на наличие изменений в будущем
        Map<String, String> controlMap = new HashMap<>();
        for(String key : imObject.getFieldMap().keySet()) {
            controlMap.put(key, imObject.getFieldMap().get(key));
        }

        // Попытка добавить элемент коллекции для проверки иммутабельности класса ImmutableClass
        map.put("key not needed", "invalid value");
        imObject.getFieldMap().put("key not needed", "invalid value");
        System.out.println((char) '\n' + "After attempt to change:" + (char) '\n' + "source map size: " + map.size());
        imObject.getFieldMap().keySet().forEach(key -> System.out.println(key + ", " +
                imObject.getFieldMap().get(key)));

        //Проверка отсутствия изменений в коллекции иммутабельного объекта относительно контрольной коллекции
        if(imObject.getFieldMap().equals(controlMap)){
            System.out.println((char) '\n' + "Immutable class object map equals the control map, check successful!");
        } else {
            System.out.println((char) '\n' + "Check failed, the object map changed.");
        }

        // Создание объекта вложенного изменяемого класса и контрольной копии строки
        ImmutableClass.InnerClass notImObject = new ImmutableClass.InnerClass("variable");
        String controlString = new String(notImObject.getAccessibleString());

        // Проверка изменяемости изменяемого класса
        notImObject.accessibleString = "new variable";
        String finMessage = "";
        if(notImObject.getAccessibleString().equals(controlString)) {
            String.valueOf(finMessage = "string didn't changed, check failed.");
        } else {
            String.valueOf(finMessage = "success, string was changed!");
        }
        System.out.println((char) '\n' + "Accessible string from inner class contains: " + notImObject.getAccessibleString() + " - " + finMessage);
    }
}