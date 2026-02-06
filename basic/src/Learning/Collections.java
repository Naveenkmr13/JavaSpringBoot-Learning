package Learning;
import java.util.*;
class Students {
    int id;
    String name;

    Students(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Collections {
    public static void main(String[] args){
        List<Students> students = new ArrayList<>();

//        <Students> is a Generic TYPE parameter.
//        It tells Java:
//        “This ArrayList can store ONLY Students(class) objects”

        students.add(new Students(1, "Naveen"));
        students.add(new Students(2, "Kumar"));

        for (Students s : students) {
            System.out.println(s.id + " " + s.name);
        }
    }
}
