package com.unitins.projetointegrador2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;
    private String nome;

    @OneToMany
    private List<Professor> professores;
}
