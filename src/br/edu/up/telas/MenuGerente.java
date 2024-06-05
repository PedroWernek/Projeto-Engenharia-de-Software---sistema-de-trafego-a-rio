package br.edu.up.telas;

import br.edu.up.util.Prompt;
import java.util.List;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuGerente {
    /* precisa manipular: aeronaves, voos e funcionários (adicionar, editar, excluir, selecionar) */
    static ControleAeronave controleAeronave = new ControleAeronave();

    public static void executar() {
        int opcao = 0;
        int pessoas = 0;

        String nome;
        String rg;

        do {
            Prompt.separador();
            Prompt.imprimir("Bem-vindo ao menu! :) Digite: ");
            Prompt.imprimir("1: Adicionar Aeronave");
            Prompt.imprimir("2: Adicionar Voo");
            Prompt.imprimir("3: Adicionar Funcionário");
            Prompt.imprimir("5: Deletar Voo");
            Prompt.imprimir("6: Deletar Funcionário");
            Prompt.imprimir("0: Sair");
            opcao = Prompt.lerInteiro();

            switch (opcao) {
                case 1 :
                Prompt.imprimir("-------------------------\n");
                int idCodigo = Prompt.lerInteiro("Codigo da aeronave: "); 
                String tipo = Prompt.lerLinha("Tipo: "); 
                int qtdAssentos = Prompt.lerInteiro("Qtd assentos: "); 
               
                Aeronave aeronave = new Aeronave();
        
                aeronave.setIdCodigo(idCodigo);
                aeronave.setQtdAssentos(qtdAssentos);
                aeronave.setTipo(tipo);
        
                controleAeronave.adicionarAeronave(aeronave);
                break;
                case 2 :
                /* blabla coisa importante 
                 * infor p adicionar tripulação abaixo:
                */
                                    

                nome = Prompt.lerLinha("Nome:");
                rg = Prompt.lerLinha("Rg:");
                int tipoTripulacao = Prompt.lerInteiro("Qual tripulante [1 - Comandante / 2 - Comissário]:");
                int idAeronautica = Prompt.lerInteiro("Id aeronautica: ");
                int idMatricula = Prompt.lerInteiro("Id matricula: ");


                if (tipoTripulacao == 1) {

                    int totalHorasVoo = Prompt.lerInteiro("Total de horas de voo: ");     
                    
                    Comandante comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);

                    comandante.setIdAeronautica(idAeronautica);
                    comandante.setIdMatricula(idMatricula);
                    comandante.setNome(nome);
                    comandante.setRg(rg);
                    comandante.setTotalHorasVoo(totalHorasVoo);
                    
                    controleAeronave.adicionarComandante(comandante, pessoas); 

                    pessoas ++;

                    break;
                } else if (tipoTripulacao == 2) {

                    String idiomas = Prompt.lerLinha("idiomas fluentes: ");

                    Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, idiomas);

                    comissario.setIdAeronautica(idAeronautica);
                    comissario.setIdMatricula(idMatricula);
                    comissario.setNome(nome);
                    comissario.setRg(rg);
                    comissario.setIdioma(idiomas);
                    controleAeronave.adicionarComissario(comissario, pessoas);
                   
                    pessoas ++;

                    break;
                }
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 0 :
                default : Prompt.imprimir("Dígito inválido!");
            }    
        } while (opcao != 0);

        /* RELATÓRIO COMANDANTE:
         *          List<Comandante> comandantes = controleAeronave.buscarComandantes();
                    int comandanteCont = 1;
                    for (Comandante comandante : comandantes) {
                        System.out.printf("Comandante %d: \n", comandanteCont);
                        System.out.println("Nome: " + comandante.getNome());
                        System.out.println("RG: " +comandante.getRg());
                        System.out.println("Id Aeronautica: " +comandante.getIdAeronautica());
                        System.out.println("Id Matricula: " +comandante.getIdMatricula());
                        System.out.println("Total horas de voo: " +comandante.getTotalHorasVoo());
                        comandanteCont ++;
                    }
         * RELATÓRIO COMISSÁRIO:
         *          List<Comissario> comissarios = controleAeronave.buscarComissarios();
                    int comissarioCont = 1;
                    for (Comissario comissario : comissarios) {
                        System.out.printf("Comissario %d: \n", comissarioCont);
                        System.out.println("Nome: " +comissario.getNome());
                        System.out.println("RG: " +comissario.getRg());
                        System.out.println("Id Aeronautica: " +comissario.getIdAeronautica());
                        System.out.println("Id Matricula: " +comissario.getIdMatricula());
                        System.out.println("Idiomas: " +comissario.getIdioma());
                        comissarioCont ++;
                    }
                    break;
         * RELATÓRIO PASSAGEIRO:
         *          List<Passageiro> passageiros = controleAeronave.buscarPassageiros();
                    int passageiroCont = 1;
                    for (Passageiro passageiro : passageiros) {
                        System.out.printf("Passageiro %d: \n", passageiroCont);
                        System.out.println("Nome: " +passageiro.getNome());
                        System.out.println("RG: " +passageiro.getRg());
                        System.out.println("Id Bagagem: " +passageiro.getIdBagagem());
                        System.out.println("Classe assento: " +passageiro.getPassagem().getClasseAssento());
                        System.out.println("Id passagem: " +passageiro.getPassagem().getIdPassagem());
                        System.out.println("Dia: " +passageiro.getPassagem().getData().getDia());
                        System.out.println("Mes: " +passageiro.getPassagem().getData().getMes());
                        System.out.println("Hora: " +passageiro.getPassagem().getData().getHora());
                        System.out.println("Minuto: " +passageiro.getPassagem().getData().getMinuto());

                        passageiroCont ++;
                        
                    }
         */
    }
}