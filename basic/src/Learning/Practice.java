package Learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Employees {
    int id;
    String name;
    double salary;

    Employees(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setSalary(double s) {
        this.salary = s;
    }

    public double getSalary(){
        return salary;
    }

    public String toString() {
        return "Employees{id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


public class Practice {
    public static void main(String[] args) {

        List<Employees> values = new ArrayList<>();

        values.add(new Employees(1,"naveen",3500));
        values.add(new Employees(2,"hari",6500));
        values.add(new Employees(3,"Saravana",6900));
        values.add(new Employees(3,"Sri",6500));

        List<Employees> q1 = values
                .stream()
                .sorted(Comparator.comparing(Employees::getSalary).reversed())
                .toList();
        System.out.println(q1);

        List<Employees> q2 = values
                .stream()
                .sorted(Comparator.comparing(Employees ::getSalary).reversed())
                .skip(1)
                .findFirst()
                .stream()
                .toList();
        System.out.println(q2);


        List<String> q3 = values
                .stream()
                .filter(entry -> entry.name.startsWith("S"))
                .map(entry -> entry.name)
                .toList();
        System.out.println(q3);
    }
}


