public class Student {
    private String studentId;
    private String fullName;
    private int yearOfBirth;
    private double averageScore;

    public Student() {
    }

    public Student(String studentId, String fullName, int yearOfBirth, double averageScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.averageScore = averageScore;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getAverageScore() {
        return this.averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "[studentId: " + this.studentId + ", fullName: " + this.fullName + ", yearOfBirth: " + this.yearOfBirth
                + ", averageScore: " + this.averageScore + "]";
    }
}