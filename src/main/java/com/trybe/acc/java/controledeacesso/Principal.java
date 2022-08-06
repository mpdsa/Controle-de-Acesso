package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

/** Classe principal. */
public class Principal {

  /** Método principal. */
  public static void main(String[] args) {
    StringBuilder opcaoMenu = new StringBuilder()
        .append("Entre com o número correspondente à opção desejada:")
        .append(System.lineSeparator())
        .append("1 - Acessar o estabelecimento")
        .append(System.lineSeparator())
        .append("2 - Finalizar sistema e mostrar relatório");
    
    Scanner scan = new Scanner(System.in);
    ArrayList<Short> idadePessoas = new ArrayList<Short>();
    short opcao = 0;

    do {
      System.out.println(opcaoMenu);
      opcao = Short.parseShort(scan.next());
      
      if (opcao != 1 && opcao != 2) {
        System.out.println("Entre com uma opção válida!");
      }

      if (opcao == 1) {
        System.out.println("Entre com a idade:");
        Short idade = Short.parseShort(scan.next());
        
        idadePessoas.add(idade);
        exibirFaixaEtaria(idade);
      }
    } while (opcao != 2);

    scan.close();

    Relatorio relatorio = new Relatorio(idadePessoas);
    relatorio.exibir();
  }
  
  /** Retorna frase de acordo com a idade de pessoa. */
  public static void exibirFaixaEtaria(int idade) {
    if (idade < 18) {
      System.out.println("Pessoa cliente menor de idade, catraca liberada!");
    }

    if (idade >= 18 && idade <= 49) {
      System.out.println("Pessoa adulta, catraca liberada!");
    }

    if (idade >= 50) {
      System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
    }
  }
  
  
}