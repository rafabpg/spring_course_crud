package com.rafael.api_cursos.modules.cursos;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "cursos")
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Length(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres")
    private String name;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Length(min = 20, max = 500, message = "A descrição deve ter entre 20 e 500 caracteres")
    private String description;

    @NotBlank(message = "Os pré-requisitos não podem estar em branco")
    @Length(min = 20, max = 500, message = "Os pré-requisitos devem ter entre 20 e 500 caracteres")
    private String preRequisites;

    @NotNull(message = "A carga horária não pode ser nula")
    @DecimalMin(value = "0.0", inclusive = false, message = "A carga horária deve ser maior que zero")
    private Float workload;

    @NotNull(message = "O valor não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    private Float value;

    @NotNull(message = "O nível não pode ser nulo")
    @Enumerated(EnumType.ORDINAL)
    private NivelEnum nivel;
    
}
