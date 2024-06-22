package com.rafael.api_cursos.exceptions;

public class CourseNameFoundException extends RuntimeException{

    public CourseNameFoundException() {
        super("Course name already exists");
    }

}
