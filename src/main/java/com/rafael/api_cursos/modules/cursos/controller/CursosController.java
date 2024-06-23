package com.rafael.api_cursos.modules.cursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.api_cursos.modules.cursos.CursosEntity;
import com.rafael.api_cursos.modules.cursos.NivelEnum;
import com.rafael.api_cursos.modules.cursos.services.CursosServices;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/cursos")
public class CursosController {
    
    @Autowired
    private CursosServices cursosServices;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursosEntity cursosEntity) {
        try {
            var result = cursosServices.createCourse(cursosEntity);
            return ResponseEntity.status(201).body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        try {
            List<CursosEntity> cursos = cursosServices.getAllCourses();
            return ResponseEntity.ok().body(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            CursosEntity result = cursosServices.getCourseById(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<Object> getByNivel(@PathVariable NivelEnum nivel) {
        try {
            List<CursosEntity> result = cursosServices.getCourseByNivel(nivel);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            cursosServices.deleteCourse(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody CursosEntity entity) {
        try {
            CursosEntity result = cursosServices.updateCourse(id, entity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
}

