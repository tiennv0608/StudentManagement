import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getAverageScore() < student2.getAverageScore()) {
            return 1;
        } else if (student1.getAverageScore() > student2.getAverageScore()) {
            return -1;
        } else {
            return student1.getFullName().compareTo(student2.getFullName());
        }
    }
}
