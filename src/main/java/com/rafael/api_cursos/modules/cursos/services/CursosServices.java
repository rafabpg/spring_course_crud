package com.rafael.api_cursos.modules.cursos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.api_cursos.exceptions.CourseCourseNotFoundException;
import com.rafael.api_cursos.exceptions.CourseNameFoundException;
import com.rafael.api_cursos.modules.cursos.CursosEntity;
import com.rafael.api_cursos.modules.cursos.NivelEnum;
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

    public List<CursosEntity> getAllCourses(){
        return this.cursosRepository.findAll();
    }

    public CursosEntity getCourseById(UUID id){
        return this.cursosRepository.findById(id).orElse(null);
    }

    public void deleteCourse(UUID id){
        this.cursosRepository.findById(id).ifPresent((course)->{
            this.cursosRepository.deleteById(id);
        });
    }

    public List<CursosEntity> getCourseByNivel(NivelEnum nivel){
        return this.cursosRepository.findByNivel(nivel);
    }
    
    public CursosEntity updateCourse(UUID id, CursosEntity cursosEntity){
        Optional<CursosEntity> existingCourseOptional = cursosRepository.findById(id);
        if(existingCourseOptional.isPresent()){
            CursosEntity existingCourse = existingCourseOptional.get();
            existingCourse.setName(cursosEntity.getName());
            existingCourse.setNivel(cursosEntity.getNivel());
            existingCourse.setDescription(cursosEntity.getDescription());
            existingCourse.setValue(cursosEntity.getValue());
            existingCourse.setNivel(cursosEntity.getNivel());
            existingCourse.setWorkload(cursosEntity.getWorkload());
            existingCourse.setPreRequisites(cursosEntity.getPreRequisites());
            return this.cursosRepository.save(existingCourse);
        }else{
            throw new CourseCourseNotFoundException();
        }
    }

}
