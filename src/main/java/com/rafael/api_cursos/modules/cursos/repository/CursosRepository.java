package com.rafael.api_cursos.modules.cursos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.api_cursos.modules.cursos.CursosEntity;
import com.rafael.api_cursos.modules.cursos.NivelEnum;

import java.util.List;
import java.util.Optional;


public interface CursosRepository extends JpaRepository<CursosEntity,UUID>{
    
    Optional<CursosEntity> findById(UUID id);
    Optional<CursosEntity> findByName(String name);
    List<CursosEntity> findByNivel(NivelEnum nivel);
    
}
