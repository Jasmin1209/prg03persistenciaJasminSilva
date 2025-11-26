/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba.curso.repository;

import br.com.ifba.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author USER
 */

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
