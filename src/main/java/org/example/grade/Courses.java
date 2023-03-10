package org.example.grade;

import java.util.List;

public class Courses {
    // 일급 콜렉션으로 변경 : 하나의 List 나 Set 만 가진 클래스. 응집도 높은 관련 로직만 가짐.
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
