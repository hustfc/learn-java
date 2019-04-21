package abstractClass;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args){
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony", 40000, 1990, 3, 15));

        System.out.println("staff size:" + staff.size());

        Employee[] a = new Employee[staff.size()];
        staff.toArray(a);

        for(Employee e : staff)
            System.out.println("name = " + e.getName() + "salary = " + e.getSalary());
    }
}
