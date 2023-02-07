package org.example.grade;

import java.util.List;

public class Courses {
    // 일급 콜렉션으로 변경
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
