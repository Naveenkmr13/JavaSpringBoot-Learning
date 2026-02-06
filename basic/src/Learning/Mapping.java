package Learning;
import java.util.*;

class Student {
    int id;
    String name;
    String course;
    int mark;

    Student(int id, String name, String course, int mark) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mark = mark;
    }
}

public class Mapping {
    public static void main(String[] args){
//        Map<Integer, String> map = new HashMap<>();
//
//        map.put(1, "Naveen");
//        map.put(2, "Srini");
//        map.put(3, "Saravanan");
//        System.out.println(map);
        Map<Integer, Student> studentsMap = new HashMap<>();

        // Adding data to Map
        studentsMap.put(101, new Student(1, "Naveen", ".Net", 45));
        studentsMap.put(102, new Student(2, "Srini", "Java", 96));
        studentsMap.put(103, new Student(3, "Saravanan", "Angular", 99));

        // Reading data from Map
        for (Map.Entry<Integer, Student> entry : studentsMap.entrySet()) {
            Integer key = entry.getKey();      // Roll number
            Student s = entry.getValue();      // Student object

            System.out.println("Key: " + key + ", Name: " + s.name + ", Course: " + s.course + ", Mark: " + s.mark);
        }
    }
}

