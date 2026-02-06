import com.models.Student;

import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of
                (new Student(1,"Naveen", ".Net", 45),
                new Student(2,"Srini", "Java", 96),
                new Student(3,"Saravanan", "Angular", 99));

        List<Student> result = students.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).toList();
        System.out.println(result);
        System.out.println(result.stream().filter(student -> student.getName().startsWith("S")).toList());
        System.out.println(students.stream().max(Comparator.comparing(Student::getMarks)).orElse(null));
        System.out.println(students.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).skip(1).findFirst());
    }
}
