/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsimulator.view;

import elevatorsimulator.controller.ErrorControl;
import elevatorsimulator.model.Edificio;
import elevatorsimulator.model.Elevador;
import elevatorsimulator.model.ElevadorException;
import elevatorsimulator.model.Pessoa;

/**
 *
 * @author alunoinf
 */
public class Painel extends ErrorControl {

    Elevador elevador;

    private void iniciar(Edificio edificio) {
        System.out.println("Criando um elevador:");

        System.out.print("Insira a capacidade Maxima: ");
        double capacidadeMaxima = getDoublePositive();

        System.out.print("Insira o tamanho do edifício: ");
        int tamanho = getIntPositive();

        elevador = new Elevador(capacidadeMaxima , edificio);
    }

    private Pessoa criarPessoa() {
        System.out.println("Criando uma pessoa:");

        System.out.print("Insira o nome da pessoa: ");
        String nome = getString();

        System.out.print("Insira o peso da pessoa: ");
        double peso = getDoublePositive();

        return new Pessoa(nome, peso);
    }

    public void menu(Edificio ed) {
        
        iniciar(ed);
        
        System.out.println();

        do {
            System.out.println("Simulador de elevador");
            System.out.println("(1) Adicionar pessoa.");
            System.out.println("(2) Remover pessoa.");
            System.out.println("(3) Subir andar.");
            System.out.println("(4) Descer andar.");
            System.out.println("(5) Exibir andar atual.");
            System.out.println("(6) Exibir informações do elevador.");
            System.out.println("(7) Exibir informações das pessoas.");
            System.out.println("(8) Sair.");
            System.out.print("Opcao: ");

            int opcao = getIntPositive();
            Pessoa pessoa;

            System.out.println();

            switch (opcao) {
                case 1:
                    pessoa = criarPessoa();

                    try {
                        elevador.adicionar(pessoa);

                        System.out.println(pessoa.getNome() + " entrou.");
                    } catch (ElevadorException erro) {
                        System.out.println(erro.getMessage());
                    }

                    System.out.println();
                    break;
                case 2:
                    System.out.print("Insira o nome da pessoa que deseja remover: ");
                    String nome = getString();
                    try {
                        elevador.remover(nome);

                        System.out.println(nome + " saiu.");
                    } catch (ElevadorException erro) {
                        System.out.println(erro.getMessage());
                    }

                    System.out.println();
                    break;
                case 3:
                    try {
                        elevador.subir();
                        System.out.println("O elevador subiu.");
                    } catch (ElevadorException erro) {
                        System.out.println(erro.getMessage());
                    }

                    System.out.println();
                    break;

                case 4:
                    try {
                        elevador.descer();
                        System.out.println("O elevador desceu.");
                    } catch (ElevadorException erro) {
                        System.out.println(erro.getMessage());
                    }

                    System.out.println();
                    break;
                case 5:
                    System.out.println(elevador.getAndarAtual() + "/" + elevador.getAndarMaximo());
                    System.out.println();
                    break;

                case 6:
                    System.out.println(elevador.toString());
                    System.out.println();
                    break;
                case 7:
                    if(elevador.getLista().isEmpty()){
                        System.out.println("Elevador vazio.");
                        break;
                    }
                    
                    for(int cont = 0 ; cont < elevador.getLista().size() ; cont ++){
                        System.out.println(elevador.getToString(cont));
                    }
                
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Encerrando simulador.");
                    return;
                default:
                    System.out.println("Opção indisponível.");
            }

        } while (true);
    }
}
