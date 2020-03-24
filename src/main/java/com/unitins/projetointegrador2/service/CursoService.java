package com.unitins.projetointegrador2.service;

import com.unitins.projetointegrador2.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    Optional<List<Curso>> findByNome(String nome);

    Optional<List<Curso>> findByDescricao(String descricao);

    void saveCurso(Curso curso);

    List<Curso> findAll();

    Optional<Curso> findById(Integer id);

    void deleteById(Integer id);
}
