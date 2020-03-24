package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Optional<List<Curso>> findByNome(String nome);

    Optional<List<Curso>> findByDescricao(String descricao);
}
