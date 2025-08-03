
package UniversityManagement;




import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, String email) {
        if (studentExists(studentId)) {
            throw new IllegalArgumentException("Student ID already exists: " + studentId);
        }
        students.add(new Student(studentId, name, email));
    }

    public void updateStudent(String studentId, String name, String email) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setName(name);
                student.setEmail(email);
                return;
            }
        }
        throw new IllegalArgumentException("Student not found: " + studentId);
    }

    public void deleteStudent(String studentId) {
        if (!students.removeIf(student -> student.getStudentId().equals(studentId))) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public boolean studentExists(String studentId) {
        return students.stream().anyMatch(student -> student.getStudentId().equals(studentId));
    }
}