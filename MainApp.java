import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    sm.addStudent(new Student(id, name, course));
                    break;

                case 2:
                    sm.showStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    Student s = sm.searchStudent(sid);

                    if (s != null)
                        System.out.println(s);
                    else
                        System.out.println("Not Found!");
                    break;

                case 4:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    sm.updateStudent(uid, newName, newCourse);
                    break;

                case 5:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    sm.deleteStudent(did);
                    break;

                case 6:
                    System.out.println("Bye!");
                    return;
            }
        }
    }
}