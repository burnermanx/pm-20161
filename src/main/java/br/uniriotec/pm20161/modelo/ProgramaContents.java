/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.pm20161.modelo;

import java.util.List;

/**
 *
 * @author bmx
 */
public class ProgramaContents {
    private List<Linha> linhas;

    public ProgramaContents() {
    }

    public ProgramaContents(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    } 
}
