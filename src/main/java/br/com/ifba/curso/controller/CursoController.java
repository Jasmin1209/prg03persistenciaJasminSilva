/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author USER
 */

@Controller
public class CursoController implements CursoIController{
    
    @Autowired
    private CursoIService cursoIService;
    
    @Override
    public Curso save (Curso curso) throws RuntimeException{
        if(StringUtil.isNullOrEmpty(curso.getCodigocurso()) || 
                StringUtil.isNullOrEmpty(curso.getNome())){
            throw new RuntimeException("Todos os dados devem ser preencidos");
        }
        return cursoIService.save(curso);
    }
    
    @Override
    public Curso update (Curso curso)throws RuntimeException{
        return cursoIService.update(curso);
    }
    
    @Override
    public void remove (Curso curso){
        cursoIService.remove(curso);
    }
    
    @Override
    public List<Curso> findAll(){
        return cursoIService.findAll();
    }
    
    @Override
    public Curso findById(Long id){
        return cursoIService.findById(id);
    }
}
