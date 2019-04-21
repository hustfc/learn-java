package abstractClass;

import java.time.*;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day){
        super(name);  //调用超类构造器
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public String getDescription(){
        return String.format("an employee with a salary of %.2f", salary);
    }
}
