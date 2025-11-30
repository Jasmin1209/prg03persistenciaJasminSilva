/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "curso")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Curso extends PersistenceEntity implements Serializable{
    
     private String codigocurso;
    
     private String nome;
    
     private boolean status;

}
