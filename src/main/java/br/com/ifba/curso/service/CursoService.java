/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class CursoService implements CursoIService{
    
    @Autowired
    private CursoRepository cursoRepository; 
    
    
    @Override
    public Curso save (Curso curso) throws RuntimeException{
        if(StringUtil.isNullOrEmpty(curso.getCodigocurso()) || 
                StringUtil.isNullOrEmpty(curso.getNome())){
            throw new RuntimeException("Todos os dados devem ser preencidos");
        }else{
            return cursoRepository.save(curso);
        }
    }
    
    @Override
    public Curso update (Curso curso)throws RuntimeException{
       
        if(cursoRepository.existsById(curso.getId())){
            return cursoRepository.save(curso);
        }else{
            throw new RuntimeException("Curso não encontrado");
        }
    }
    
    @Override
    public void remove (Curso curso){
        if(cursoRepository.existsById(curso.getId())){
            cursoRepository.delete(curso);
        }else{
            throw new RuntimeException("Curso não encontrado");
        }
    }
    
    @Override
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }
    
    @Override
    public Curso findById(Long id){
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}
