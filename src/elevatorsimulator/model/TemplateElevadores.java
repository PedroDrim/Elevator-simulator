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
public interface TemplateElevadores {
    public void adicionar(Pessoa pessoa);
    public void remover(String nome);
    public void subir();
    public void descer();
    public int getAndarAtual();
}
