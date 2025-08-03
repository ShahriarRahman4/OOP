
package UniversityManagement;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    public void addCourse(String courseId, String courseName, int credits) {
        if (courseExists(courseId)) {
            throw new IllegalArgumentException("Course ID already exists: " + courseId);
        }
        courses.add(new Course(courseId, courseName, credits));
    }

    public void updateCourse(String courseId, String courseName, int credits) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                course.setCourseName(courseName);
                course.setCredits(credits);
                return;
            }
        }
        throw new IllegalArgumentException("Course not found: " + courseId);
    }

    public void deleteCourse(String courseId) {
        if (!courses.removeIf(course -> course.getCourseId().equals(courseId))) {
            throw new IllegalArgumentException("Course not found: " + courseId);
        }
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public boolean courseExists(String courseId) {
        return courses.stream().anyMatch(course -> course.getCourseId().equals(courseId));
    }
}