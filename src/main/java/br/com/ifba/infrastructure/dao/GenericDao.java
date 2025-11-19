/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author USER
 * @param <Entity>
 * 
 * Implementa métodos genéricos de CRUD 
 * Usada como base para todos os DAOs do sistema
 */

@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity>{

    protected static EntityManager entityManager;
    
    static {
        //Lê o persistence.xml e estabele acesso ao banco de dados "curso"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("curso");
        //responsável pelas operações CRUD do banco de dados
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Override
    public Entity save(Entity obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public Entity update(Entity obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void remove(Entity obj) {
        obj = findById(obj.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery(("from " + getTypeClass().getName())).getResultList();
    }

    @Override
    public Entity findById(Long id) {
       return (Entity) entityManager.find(getTypeClass(), id);
    }

    @SuppressWarnings("unchecked")
    protected Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
    
}
