/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator.model;

/**
 *
 * @author alunoinf
 */
public class Edificio {
    private String nome;
    private final int ANDARES;

    public Edificio(String nome, int quantidadeAndares) {
        this.nome = nome;
        ANDARES = quantidadeAndares;
    }

    public String getNome() {
        return nome;
    }

    public int getANDARES() {
        return ANDARES;
    }
}
