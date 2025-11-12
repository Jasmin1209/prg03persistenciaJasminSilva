/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import java.util.List;


/**
 *
 * @author USER
 */
public class CursoDAO extends GenericDao<Curso> implements CursoIDAO{
    
    //Atualiza os dados de um curso existente com base no ID.
    public void atualizarcurso(Long id, String codigocurso, String nome, boolean status){ 
        Curso c = buscarPorId(id); // Busca o curso existente
        if(c != null){
             // Atualiza apenas os campos desejados
             c.setCodigocurso(codigocurso);
             c.setNome(nome);
             atualizar(c); //método herdado
        }
    }
    
    public void removercurso(Long id){
        Curso c = buscarPorId(id);
        if(c != null){
            remover(c);
        }
    }
    
    public List<Curso> listarcursos(){
        return listarTodos();
    }
    
    public Curso buscar(Long id){
        return buscarPorId(id);
    } 

    
}
