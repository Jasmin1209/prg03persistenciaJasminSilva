/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author USER
 */
public class CursoService implements CursoIService{
    private final CursoIDao cursoDao = new CursoDao(); 
    //cursoDao herda todas as funcionalidades do GenericDao sendo possível acessa-las
    
    @Override
    public Curso save (Curso curso) throws RuntimeException{
        if(StringUtil.isNullOrEmpty(curso.getCodigocurso()) || 
                StringUtil.isNullOrEmpty(curso.getNome())){
            throw new RuntimeException("Todos os dados devem ser preencidos");
        }else{
            return cursoDao.save(curso);
        }
    }
    
    @Override
    public Curso update (Curso curso)throws RuntimeException{
        Curso c = cursoDao.findById(curso.getId());
        
        if(StringUtil.isNullOrEmpty(c.getCodigocurso()) || 
                StringUtil.isNullOrEmpty(c.getNome())){
            throw new RuntimeException("Curso não encontrado");
        }else{
            
        return cursoDao.update(c);
        }
    }
    
    @Override
    public void remove (Curso curso){
        Curso c = cursoDao.findById(curso.getId());
        if(c == null){
            throw new RuntimeException("Todos os dados devem ser preencidos");
        }else{
            cursoDao.remove(c);
        }
    }
    
    @Override
    public List<Curso> findAll(){
        return cursoDao.findAll();
    }
    
    @Override
    public Curso findById(Long id){
        return cursoDao.findById(id);
    }
}
