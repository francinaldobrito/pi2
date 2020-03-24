package com.unitins.projetointegrador2.service;

import com.unitins.projetointegrador2.model.Curso;
import com.unitins.projetointegrador2.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Optional<List<Curso>> findByNome(String nome) {
        return cursoRepository.findByNome(nome);
    }

    @Override
    public Optional<List<Curso>> findByDescricao(String descricao) {
        return cursoRepository.findByDescricao(descricao);
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }
}
