package br.uniriotec.pm20161.modelo;

import java.util.List;

/**
 *
 * @author Thiago Passos
 */
public class Linha {
    private String nome;
    private List<Professor> professores;

    public Linha() {
    }

    public Linha(String nome, List<Professor> professores) {
        this.nome = nome;
        this.professores = professores;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
