/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator.model;

import java.util.Objects;

/**
 *
 * @author alunoinf
 */
public class Pessoa {
    private String nome;
    private double peso;
    
    public Pessoa(String nome ,double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Double.doubleToLongBits(this.peso) == Double.doubleToLongBits(other.peso);
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Nome: ");
        builder.append(nome);
        builder.append("\n");
        builder.append("Peso: ");
        builder.append(peso);
        builder.append(" Kg");
        
        return builder.toString();
    }
    
    
}
