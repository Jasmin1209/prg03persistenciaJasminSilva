/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


/**
 *
 * @author USER
 */
public class CursoDAO {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("curso");

    
    
    public void salvar(Curso cursos){
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        if(cursos == null){
            entity.persist(cursos);
        }else{
            entity.merge(cursos);
        }
        entity.getTransaction().commit();
        entity.close();
    }
    
    public List<Curso> listar(){ //vai ser usado na tela inicial para listar todos os objetos
        EntityManager entity = entityManagerFactory.createEntityManager();
        List<Curso> cursos = entity.createQuery("from Curso", Curso.class).getResultList();
        entity.close();
        return cursos;
    }
    
    public void remover(Long id){ //Remove um curso do banco de dados pelo seu ID.
        EntityManager entity = entityManagerFactory.createEntityManager();
        Curso cursosremover = entity.find(Curso.class, id);
        if(cursosremover != null){
            entity.getTransaction().begin();
            entity.remove(cursosremover);
            entity.getTransaction().commit();
        }
        entity.close();
    }
    
    public Curso buscar(Long idcurso){ //Busca um curso específico pelo ID e o retorna.
        EntityManager entity =entityManagerFactory.createEntityManager();
        Curso c = entity.find(Curso.class, idcurso);
        entity.close();
        return c;
    }
    
    //Atualiza os dados de um curso existente com base no ID.
    public void atualizar(Long id, String codigocurso, String nome, boolean status){ 
        EntityManager entity = entityManagerFactory.createEntityManager();
        
        try{
        entity.getTransaction().begin();
        
        // Busca o curso existente
        Curso c = entity.find(Curso.class, id);
        
        if(c != null){
             // Atualiza apenas os campos desejados
             c.setCodigocurso(codigocurso);
             c.setNome(nome);
             entity.merge(c); //merge vai salvar as informações usadas (somente as que já existem)
        }
        
        entity.getTransaction().commit();
        
        }catch(Exception e){
            entity.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entity.close();
        }
    }
    
}
