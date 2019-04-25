package map;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args){
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144", new Employee("Amy"));
        staff.put("567", new Employee("Harry"));
        staff.put("157", new Employee("Gary"));
        staff.put("456", new Employee("France"));

        System.out.println(staff);

        //remove
        staff.remove("144");

        //replace
        staff.put("567", new Employee("place"));

        System.out.println(staff.get("567"));

        staff.forEach((k, v) -> System.out.println("key=" + k + ", val=" + v));
    }
}
