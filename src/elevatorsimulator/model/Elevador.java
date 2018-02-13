/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator.model;

import java.util.ArrayList;

/**
 *
 * @author alunoinf
 */
public class Elevador implements TemplateElevadores {

    private double utilizacaoMaxima;
    private double utilizacaoAtual;

    private int andarMaximo;
    private int andarAtual;
    
    private ArrayList<Pessoa> lista;
    private Edificio edificio;
    
    public Elevador(double capacidadeMaxima ,Edificio edificio) {
        this.utilizacaoMaxima = capacidadeMaxima;

        lista = new ArrayList<>();
        this.edificio = edificio;
        
        andarAtual = 0;
        andarMaximo = edificio.getANDARES();
        utilizacaoAtual = 0;
    }

    public double getUtilizacaoMaxima() {
        return utilizacaoMaxima;
    }

    public double getUtilizacaoAtual() {
        return utilizacaoAtual;
    }

    public int getAndarMaximo() {
        return andarMaximo;
    }

    @Override
    public int getAndarAtual() {
        return andarAtual;
    }
    
    public int getPessoasDentro(){
        return lista.size();
    }

    public ArrayList<Pessoa> getLista() {
        return lista;
    }
    
    public String getToString(int id) {
        if (id > lista.size()) {
            throw new ElevadorException("O elevador está vazio.");
        }
        
        Pessoa pessoa = lista.get(id);
        String nome = pessoa.toString();

        return nome;
    }

    public Edificio getEdificio() {
        return edificio;
    }
    
    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Quantidade de Pessoas : ");
        builder.append(getPessoasDentro());
        builder.append("\n");
        builder.append("Capacidade : ");
        builder.append(getUtilizacaoAtual());
        builder.append(" Kg / ");
        builder.append(getUtilizacaoMaxima());
        builder.append(" Kg");
        builder.append("\n");
        builder.append("Andar : ");
        builder.append(getAndarAtual());
        builder.append(" / ");
        builder.append(getAndarMaximo());

        return builder.toString();
    }

    @Override
    public void adicionar(Pessoa pessoa) {
        for (Pessoa busca : lista) {
            if (busca.getNome().equals(pessoa.getNome())) {
                throw new ElevadorException("Já existe uma pessoa com o mesmo nome.");
            }
        }

        if (pessoa.getPeso() + utilizacaoAtual <= utilizacaoMaxima) {
            utilizacaoAtual += pessoa.getPeso();
            lista.add(pessoa);
        } else {
            throw new ElevadorException("A pessoa não pôde entrar pois excederia a capacidade máxima.");
        }
    }

    @Override
    public void remover(String nome) {
        Pessoa pessoa;

        if (lista.isEmpty()) {
            throw new ElevadorException("O elevador está vazio.");
        } else {
            for (int cont = 0; cont < lista.size(); cont++) {
                pessoa = lista.get(cont);

                if (nome.equals(pessoa.getNome())) {
                    lista.remove(cont);
                    utilizacaoAtual -= pessoa.getPeso();

                    return;
                }
            }
            throw new ElevadorException("A pessoa a ser removida não existe.");
        }
    }

    @Override
    public void subir() {
        if (andarAtual < andarMaximo) {
            andarAtual++;
        } else {
            throw new ElevadorException("O elevador já está no ultimo andar.");
        }
    }

    @Override
    public void descer() {
        if (andarAtual > 0) {
            andarAtual--;
        } else {
            throw new ElevadorException("O elevador já está no térreo.");
        }
    }
}
