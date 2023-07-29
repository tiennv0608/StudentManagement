import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<Student> studentList;
    Scanner sc = new Scanner(System.in);

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student("SS01", "Dang Chau Anh", 1999, 9.8));
        studentList.add(new Student("SS02", "Nguyen Ngoc Nga", 2000, 8.3));
        studentList.add(new Student("SS03", "Hoang Thi Van", 2000, 6.4));
        studentList.add(new Student("SS04", "Pham Xuan Phong", 1999, 8.3));
        studentList.add(new Student("SS05", "Nghiem Xuan Minh", 1996, 7.5));
    }

    public List<Student> getList() {
        return studentList;
    }

    public Student enterStudentInfo(String studentId) {
        Student student = new Student();
        System.out.println("Enter full name:");
        String fullName = sc.nextLine();
        System.out.println("Enter year of birth:");
        int yearOfBirth = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter average score:");
        double averageScore = sc.nextDouble();
        sc.nextLine();
        student.setStudentId(studentId);
        student.setFullName(fullName);
        student.setYearOfBirth(yearOfBirth);
        student.setAverageScore(averageScore);
        return student;
    }

    public void displayStudentList(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public int countStudentList() {
        return studentList.size();
    }

    public int findStudentById(String studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public void updateStudentInfoByStudentId(String studentId) {
        int index = findStudentById(studentId);
        if (index == -1) {
            System.out.println("Cannot find student information");
        } else {
            System.out.println("Information: " + studentList.get(index));
            Student student = enterStudentInfo(studentId);
            studentList.set(index, student);
            System.out.println("Update successfully");
        }
    }

    public void deleteStudentByStudentId(String studentId) {
        int index = findStudentById(studentId);
        if (index == -1) {
            System.out.println("Cannot find student information");
        } else {
            System.out.println("Information: " + studentList.get(index));
            System.out.println("Do you want to delete this student (y/n): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                studentList.remove(index);
                System.out.println("Delete successfully");
            } else {
                System.out.println("Delete cancelled!");
            }
        }
    }

    public List<Student> findStudentByName(String name) {
        List<Student> list = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFullName().contains(name)) {
                list.add(student);
            }
        }
        return list;
    }

    public void exportStudentListOrderByScore() {
        List<Student> list = new ArrayList<>();
        list.addAll(studentList);
        Collections.sort(list, new StudentComparator());
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void displayTop3() {
        List<Student> list = new ArrayList<>();
        list.addAll(studentList);
        Collections.sort(list, new StudentComparator());
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }
}
