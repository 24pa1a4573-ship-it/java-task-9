import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Asha", 85));
        list.add(new Student(2, "Ravi", 90));
        list.add(new Student(1, "Asha", 85));

        Set<Integer> seen = new HashSet<>();
        List<Student> unique = new ArrayList<>();
        for (Student s : list) {
            if (seen.add(s.id)) unique.add(s);
        }

        Map<Integer, Student> map = new HashMap<>();
        for (Student s : unique) map.put(s.id, s);

        unique.sort(Comparator.comparingInt(a -> a.marks));

        System.out.printf("%-5s %-10s %-5s%n", "ID", "Name", "Marks");
        for (Student s : unique) {
            System.out.printf("%-5d %-10s %-5d%n", s.id, s.name, s.marks);
        }
    }
}