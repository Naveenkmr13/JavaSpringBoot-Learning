package Learning;

import java.util.*;

public class Streams {
    public static void main(String[] args) {
        int a =1 ;
        int b = 2;
        String country = "India";
        char charactor = 's';
        boolean decision = true;
        int arr[] = {1,3,4,6,7};
        String strArr[] = {"india", "pakistan", "Italy"};

        System.out.println("Addition of a+b : "+ (a+b));
        System.out.println("Array len : "+ arr.length);
        System.out.println("Second value in the array : "+ strArr[1]);

        List<String> countries = new ArrayList<>();
        countries.add("india");
        countries.add("Nepal");
        countries.add("Pakistan");
        countries.add("Italy");

        System.out.println(countries);
        System.out.println(countries.contains("india"));

        countries.stream().sorted();

        Map<Integer, String> countryMap = new HashMap<>();
        countryMap.put(345, "India");
        countryMap.put(226, "India");
        countryMap.put(76, "India");

        System.out.println(countryMap.get(345));


        Map<String, List<String>> courses = new HashMap<>();
        courses.put("Java", List.of("Naveen", "Srini"));
        courses.put(".Net", List.of("Sakthi", "Mani"));
        courses.put("phython", List.of("Tamil", "Hari"));

        List<Map.Entry<String, List<String>>> entries = courses.entrySet().
                stream()
                .filter(entry -> entry.getKey().equals("Java"))
                .toList();
        System.out.println("Java Students" + entries);

        List<List<String>> value = courses.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals("Java") || entry.getKey().equals("phython"))
                .map(entry-> entry.getValue())
                .toList();
        System.out.println("Java & Phython Students : " + value);

//        System.out.println("List of Java Students : " + courses.get("Java"));
//
//        for (Map.Entry<String, List<String>> course: courses.entrySet()) {
//            if (course.getKey().equals("Java")) {
//                System.out.println(course.getValue());
//            }
//        }

        Map<String,Integer> games = new HashMap<>();
        games.put("cricket", 5);
        games.put("football",3);
        games.put("tennis",6);



         List<String> Valuess= games.entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .toList();
        System.out.println(Valuess);

    }

}