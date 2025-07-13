import java.util.*;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double average() {
        int sum = 0;
        for (int g : grades) sum += g;
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    int highest() {
        return grades.isEmpty() ? 0 : Collections.max(grades);
    }

    int lowest() {
        return grades.isEmpty() ? 0 : Collections.min(grades);
    }

    void displayReport() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + average());
        System.out.println("Highest: " + highest());
        System.out.println("Lowest: " + lowest());
        System.out.println("---------------------------");
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            Student s = new Student(name);

            System.out.print("Enter number of grades: ");
            int g = sc.nextInt();
            for (int j = 0; j < g; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                s.addGrade(sc.nextInt());
            }
            sc.nextLine(); 
            students.add(s);
        }

        System.out.println("\n--- STUDENT REPORT ---");
        for (Student s : students) {
            s.displayReport();
        }
    }
}