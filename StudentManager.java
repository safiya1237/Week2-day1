import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student s) {
        list.add(s);
        System.out.println("Student Added!");
    }

    public void showStudents() {
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        Student s = searchStudent(id);
        if (s != null) {
            list.remove(s);
            System.out.println("Student Deleted!");
        }
        else {
            System.out.println("Student Not Found!");
        }
    }

    public void updateStudent(int id, String newName, String newCourse) {
        Student s = searchStudent(id);
        if (s != null) {
            s.setName(newName);
            s.setCourse(newCourse);
            System.out.println("Student Updated!");
        }
        else {
            System.out.println("Student Not Found!");
        }
    }
}
