/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author USER
 */
@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcurso;
    
    private String codigocurso;
    private String nome;
    private boolean ativo;

    public Curso() {
        this.codigocurso = codigocurso;
        this.nome = nome;
        this.ativo = ativo;
        this.idcurso = (long) (Math.random() * 100);
    }

    public String getCodigocurso() {return codigocurso;}
    public void setCodigocurso(String codigocurso) {this.codigocurso = codigocurso;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public boolean isAtivo() {return ativo;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}

    public long getIdcurso() {return idcurso;}
    
    @Override
    public String toString() {
        return "Curso{" + "codigocurso=" + codigocurso + ", nome=" + nome + ", ativo=" + ativo + '}';
    }
    
    
}
