package com.rafael.api_cursos.modules.cursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.api_cursos.modules.cursos.CursosEntity;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cursos")
public class CursosController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody CursosEntity cursosEntity) {
        System.out.println("cursosEntity");
        System.out.println(cursosEntity.getName());
    }
    

}
