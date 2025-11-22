/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "curso")
public class Curso extends PersistenceEntity implements Serializable{
    
    private String codigocurso;
    
    private String nome;
    
    private boolean status;

    public Curso() {
        this.codigocurso = codigocurso;
        this.nome = nome;
        this.status = true;
    }
    
    public String getCodigocurso() {return codigocurso;}
    public void setCodigocurso(String codigocurso) {this.codigocurso = codigocurso;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public boolean isAtivo() {return status;}
    public void setAtivo(boolean ativo) {this.status = ativo;}
    
    @Override
    public String toString() {
        return "Curso{" + "codigocurso=" + codigocurso + ", nome=" + nome + ", ativo=" + status + '}';
    }
    
    
}
