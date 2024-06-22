package com.rafael.api_cursos.modules.cursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.api_cursos.modules.cursos.CursosEntity;
import com.rafael.api_cursos.modules.cursos.services.CursosServices;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cursos")
public class CursosController {
    
    @Autowired
    private CursosServices cursosServices;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursosEntity cursosEntity) {
        try {
            var result = cursosServices.createCourse(cursosEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

}

//dd7787b8-5443-4f0c-a10e-2be159a461b7
