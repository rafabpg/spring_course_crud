package com.rafael.api_cursos.exceptions;

public class CourseCourseNotFoundException extends RuntimeException {
    public CourseCourseNotFoundException() {
        super("Course Not Found");
    }
}
