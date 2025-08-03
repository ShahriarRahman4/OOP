
package UniversityManagement;



import java.util.ArrayList;
import java.util.List;

public class EnrollmentManager {
    private List<Enrollment> enrollments;
    private StudentManager studentManager;
    private CourseManager courseManager;

    public EnrollmentManager(StudentManager studentManager, CourseManager courseManager) {
        this.enrollments = new ArrayList<>();
        this.studentManager = studentManager;
        this.courseManager = courseManager;
    }

    public void enrollStudent(String studentId, String courseId) {
        if (!studentManager.studentExists(studentId)) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        if (!courseManager.courseExists(courseId)) {
            throw new IllegalArgumentException("Course not found: " + courseId);
        }
        enrollments.add(new Enrollment(studentId, courseId));
    }

    public List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void removeEnrollmentsByStudent(String studentId) {
        enrollments.removeIf(enrollment -> enrollment.getStudentId().equals(studentId));
    }

    public void removeEnrollmentsByCourse(String courseId) {
        enrollments.removeIf(enrollment -> enrollment.getCourseId().equals(courseId));
    }
}