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
public class Programas {
    private List<Programa> programas;

    public Programas() {
    }

    public Programas(List<Programa> programas) {
        this.programas = programas;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }
}
