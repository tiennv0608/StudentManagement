import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            menu();
            System.out.println("Enter choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    boolean isValid = true;
                    String studentId = "";
                    System.out.println("Enter student id:");
                    do {
                        studentId = sc.nextLine();
                        int index = studentManagement.findStudentById(studentId);
                        if (studentId.length() > 4 || index != -1) {
                            System.out.println(
                                    "studentId is too long(only 4 characters) or duplicated! Re input studentId:");
                        } else {
                            isValid = false;
                        }
                    } while (isValid);
                    Student student = studentManagement.enterStudentInfo(studentId);
                    studentManagement.addStudent(student);
                    break;
                }
                case 2: {
                    List<Student> list = studentManagement.getList();
                    studentManagement.displayStudentList(list);
                    break;
                }
                case 3: {
                    int number = studentManagement.countStudentList();
                    System.out.println("Number of student in list is: " + number);
                    break;
                }
                case 4: {
                    System.out.println("Enter student id:");
                    String studentId = sc.nextLine();
                    int index = studentManagement.findStudentById(studentId);
                    if (index == -1) {
                        System.out.println("Cannot find student information");
                    } else {
                        System.out.println(studentManagement.getList().get(index));
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter student id:");
                    String studentId = sc.nextLine();
                    studentManagement.updateStudentInfoByStudentId(studentId);
                    break;
                }
                case 6: {
                    System.out.println("Enter student id:");
                    String studentId = sc.nextLine();
                    studentManagement.deleteStudentByStudentId(studentId);
                    break;
                }
                case 7: {
                    System.out.println("Enter student name: ");
                    String name = sc.nextLine();
                    List<Student> list = studentManagement.findStudentByName(name);
                    if (list.size() == 0) {
                        System.out.println("There is no student match that name");
                    } else {
                        studentManagement.displayStudentList(list);
                    }
                    break;
                }
                case 8: {
                    studentManagement.exportStudentListOrderByScore();
                    break;
                }
                case 9: {
                    studentManagement.displayTop3();
                    break;
                }
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice! Re input: ");
            }
        }
    }

    private static void menu() {
        System.out.println("--------------------------------------");
        System.out.println("Student management:");
        System.out.println("1. Add new student");
        System.out.println("2. Display list student");
        System.out.println("3. Count the number of list student");
        System.out.println("4. Find student by student id");
        System.out.println("5. Update information student");
        System.out.println("6. Delete student");
        System.out.println("7. Find student by full name");
        System.out.println("8. Display list student sort by score");
        System.out.println("9. Print top 3 highest score student");
        System.out.println("0. Exit");
    }
}
