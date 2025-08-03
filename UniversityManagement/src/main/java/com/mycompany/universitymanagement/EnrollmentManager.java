package com.mycompany.universitymanagement;

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

    public boolean enrollStudent(String studentId, String courseId) {
        if (!studentManager.studentExists(studentId) || !courseManager.courseExists(courseId)) {
            return false;
        }
        enrollments.add(new Enrollment(studentId, courseId));
        return true;
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

    public List<Enrollment> getEnrollmentsByStudent(String studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enrollment> getEnrollmentsByCourse(String courseId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseId().equals(courseId)) {
                result.add(e);
            }
        }
        return result;
    }
}