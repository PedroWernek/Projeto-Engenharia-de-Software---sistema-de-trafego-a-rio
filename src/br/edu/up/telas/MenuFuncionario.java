package br.edu.up.telas;

import br.edu.up.controles.ControleComandante;
import br.edu.up.controles.ControleComissario;
import br.edu.up.util.Prompt;

public class MenuFuncionario {
  /* Pedro - criando controle Comandante */
  public ControleComandante controleComandante;
  public ControleComissario controleComissario;

  public MenuFuncionario() {
    this.controleComandante = new ControleComandante();
    this.controleComissario = new ControleComissario();
  }

  public void adicionarFuncionario() {
    Prompt.imprimir("--------MENU ADICIONAR FUNCIONARIO--------");
    Prompt.imprimir("1- Comandante");
    Prompt.imprimir("2- Comissario");
    Prompt.imprimir("------------------------------------------");

    int escolha = Prompt.lerInteiro();

    switch (escolha) {
      case 1:
        adicionarComandante();
        break;
      case 2:
        break;
      default:
        Prompt.imprimir("Escolha invalida");
        adicionarFuncionario();
        break;
    }

  }

  // TODO fazer Remover Funcionarios
  public void removerFuncionario() {
    Prompt.imprimir("--------MENU REMOVER FUNCIONARIO--------");
    Prompt.imprimir("1- Comandante");
    Prompt.imprimir("2- Comissario");
    Prompt.imprimir("------------------------------------------");

    int escolha = Prompt.lerInteiro();

    switch (escolha) {
      case 1:
        removerComandante();
        break;
      case 2:
        break;
      default:
        Prompt.imprimir("Escolha invalida");
        removerFuncionario();
        break;
    }

  }
  // TODO fazer ListarFuncionarios
  public void listarFuncionarios() {
    Prompt.imprimir("--------MENU REMOVER FUNCIONARIO--------");
    Prompt.imprimir("1- Comandante");
    Prompt.imprimir("2- Comissario");
    Prompt.imprimir("------------------------------------------");

    int escolha = Prompt.lerInteiro();

    switch (escolha) {
      case 1:
        removerComandante();
        break;
      case 2:
        break;
      default:
        Prompt.imprimir("Escolha invalida");
        listarFuncionarios();
        break;
    }

  }

  public void adicionarComandante() {

    String nome = Prompt.lerLinha("Nome:");
    String rg = Prompt.lerLinha("RG:");
    int idAeronautica = Prompt.lerInteiro("Id aeronautica:");
    int idMatricula = Prompt.lerInteiro("Id matricula:");
    int totalHorasVoo = Prompt.lerInteiro("Total de horas de voo:");

    controleComandante.adicionar(nome, rg, idAeronautica, idMatricula, totalHorasVoo);

    if (controleComandante.gravar()) {
      Prompt.imprimir("Comandante adicionado com sucesso!");
    } else {
      Prompt.imprimir("Erro ao adicionar comandante!");
    }

    Prompt.linhaEmBranco();
    Prompt.pressionarEnter();
  }

  public void listarComandantes(){
    Prompt.imprimir(controleComandante.listar());
  }

  public void removerComandante(){
    listarComandantes();
    String rg = Prompt.lerLinha("Digite o RG do comandante que deseja remover:");

    if(controleComandante.remover(rg)){
      Prompt.imprimir("Comandante removido com sucesso!");
      controleComandante.gravar();
    }else{
      Prompt.imprimir("Erro ao remover comandante!");
    }
  }
}
