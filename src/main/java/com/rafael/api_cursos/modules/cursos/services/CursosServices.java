package com.rafael.api_cursos.modules.cursos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.api_cursos.exceptions.CourseNameFoundException;
import com.rafael.api_cursos.modules.cursos.CursosEntity;
import com.rafael.api_cursos.modules.cursos.repository.CursosRepository;

@Service
public class CursosServices {

    @Autowired
    private CursosRepository cursosRepository;

    public CursosEntity createCourse(CursosEntity cursosEntity){
        this.cursosRepository.findByName(cursosEntity.getName()).ifPresent((course)->{
            throw new CourseNameFoundException();
        });
        return this.cursosRepository.save(cursosEntity);
    }

}
