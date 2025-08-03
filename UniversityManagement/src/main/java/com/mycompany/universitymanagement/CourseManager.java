package com.mycompany.universitymanagement;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    public void addCourse(String courseId, String courseName, int credits) {
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
    }

    public void deleteCourse(String courseId) {
        courses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public boolean courseExists(String courseId) {
        return courses.stream().anyMatch(course -> course.getCourseId().equals(courseId));
    }
}