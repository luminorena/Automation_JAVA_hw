import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] arr = {12, 23, 45, 434, 52, 43, 34};
        for (int i = arr.length-1; i >= 0;  i --) {
            System.out.println(arr[i]);
        }

        Map<String, Contact> contactMap = Map.of("Olga",
                new Contact("1234", "34"));
        Set<Map.Entry<String, Contact>> entries = contactMap.entrySet();
        for (Map.Entry<String, Contact> entry: entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }


    }
}
