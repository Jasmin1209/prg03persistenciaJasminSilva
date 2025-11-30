/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
@RequiredArgsConstructor
public class CursoService implements CursoIService{
    
    private final CursoRepository cursoRepository; 
    
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CursoService.class);
    
    @Override
    public Curso save (Curso curso) throws RuntimeException{
        if(StringUtil.isNullOrEmpty(curso.getCodigocurso()) || 
                StringUtil.isNullOrEmpty(curso.getNome())){
            throw new RuntimeException("Todos os dados devem ser preencidos");
        }else{
            log.info("Salvando curso");
            return cursoRepository.save(curso);
        }
    }
    
    @Override
    public Curso update (Curso curso)throws RuntimeException{
       
        if(cursoRepository.existsById(curso.getId())){
            log.info("Atualizando dados");
            return cursoRepository.save(curso);
        }else{
            throw new RuntimeException("Curso não encontrado");
        }
    }
    
    @Override
    public void remove (Curso curso){
        if(cursoRepository.existsById(curso.getId())){
            log.info("Deletando dados");
            cursoRepository.delete(curso);
        }else{
            throw new RuntimeException("Curso não encontrado");
        }
    }
    
    @Override
    public List<Curso> findAll(){
        log.info("Listando todos os dados");
        return cursoRepository.findAll();
    }
    
    @Override
    public Curso findById(Long id){
        log.info("Dados encontrados");
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}
