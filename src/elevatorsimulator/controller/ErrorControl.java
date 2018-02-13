/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator.controller;

import java.util.Scanner;

/**
 *
 * @author alunoinf
 */
public abstract class ErrorControl {

    Scanner scan = new Scanner(System.in);

    public String getString() {
        String palavra = scan.nextLine();

        return palavra;
    }

    public double getDoublePositive() {
        String palavra;
        double retorno;

        do {
            try {
                palavra = scan.nextLine();
                retorno = Double.parseDouble(palavra);
                
                if (retorno <= 0) {
                    System.err.println("Insira um número inteiro positivo.");
                } else {
                    break;
                }
                
                break;
            } catch (RuntimeException erro) {
                System.err.println("Insira um número double.");
            }
        } while (true);

        return retorno;
    }

    public int getIntPositive() {
        String palavra;
        int retorno;

        do {
            try {
                
                palavra = scan.nextLine();
                retorno = Integer.parseInt(palavra);
                if (retorno <= 0) {
                    System.err.println("Insira um número inteiro positivo.");
                } else {
                    break;
                }

            } catch (RuntimeException erro) {
                System.err.println("Insira um número inteiro positivo.");
            }
        } while (true);

        return retorno;
    }
}
