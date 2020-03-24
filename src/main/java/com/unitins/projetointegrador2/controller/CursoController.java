package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Curso;
import com.unitins.projetointegrador2.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Controller
@RequestMapping("/curso")
public class CursoController {

    private CursoService cursoService;

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "listarCurso";
    }

    @GetMapping("/filtrarPorNome")
    public String listarFiltradaPorNome(@RequestParam(required = false) String nome,
                                        Model model) {

        model.addAttribute("cursos", cursoService.findByNome(nome));
        return "listarCurso";
    }

    @GetMapping("/filtrarPorDescricao")
    public String listarFiltradaPorDescricao(@RequestParam(required = false) String descricao,
                                             Model model) {

        model.addAttribute("cursos", cursoService.findByDescricao(descricao));
        return "listarCurso";
    }

    @PostMapping()
    public String salvarCurso(@Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/criarCurso";
        }
        cursoService.saveCurso(curso);

        model.addAttribute("cursos", cursoService.findAll());
        return "redirect:/listarCurso";
    }

    @PostMapping("/editarCurso/{id}")
    public String editarAluno(@PathVariable(required = false) Integer id, Model model) {
        Curso curso = cursoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar esse Curso"));
        model.addAttribute("curso", curso);
        return "redirect:/cadastrarCurso";
    }

    @RequestMapping("/excluirCurso/{id}")
    public String excluirCurso(@PathVariable Integer id, Model model) {
        try {
            cursoService.deleteById(id);
            model.addAttribute("cursos", cursoService.findAll());
        } catch (ConstraintViolationException constraintViolationException) {
            model.addAttribute("erroAoExcluir", true);
        }
        return "redirect:/listarCurso";
    }

}
