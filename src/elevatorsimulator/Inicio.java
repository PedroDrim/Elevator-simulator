/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator;

import elevatorsimulator.model.Edificio;
import elevatorsimulator.view.Painel;

/**
 *
 * @author alunoinf
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Painel painel = new Painel();
        Edificio ed = new Edificio("Ed.Teste", 50);
        painel.menu(ed);
    }
    
}
