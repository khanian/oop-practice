package org.example.grade;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
     * MVC패턴(Model-View-Controller) 기반으로 구현한다.
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
        // (학점수×교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            // 계산을 Course class에 전담시키자. 왜? 응집도를 높여서 변화가 있을 때 한 군데만 수정.
            // multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();

        }

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        // (학점수×교과목 평점)의 합계/수강신청 총학점 수
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
