package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/** Classe Relatorio. */
public class Relatorio {
  ArrayList<Short> idadePessoas = new ArrayList<Short>();
  int quantCriancas = 0;
  int quantAdultos = 0;
  int quantIdosos = 0;
  double porcentcriancas = 0;
  double porcentAdultos = 0;
  double porcentIdosos = 0;
  
  
  DecimalFormat decimalF = new DecimalFormat("#.##");
  
  /** Classe construtora. */
  public Relatorio(ArrayList<Short> idadePessoas) {
    this.idadePessoas = idadePessoas;
    
    for (int i = 0; i < idadePessoas.size(); i++) {
      if (idadePessoas.get(i) < 18) {
        this.quantCriancas += 1;
      }
      
      if (idadePessoas.get(i) >= 18 && idadePessoas.get(i) <= 49) {
        this.quantAdultos += 1;
      }
      
      if (idadePessoas.get(i) >= 50) {
        this.quantIdosos += 1;
      }
    }
    
    this.porcentcriancas = (this.quantCriancas * 100.0) / idadePessoas.size();
    this.porcentAdultos = (this.quantAdultos * 100.0) / idadePessoas.size();
    this.porcentIdosos = (this.quantIdosos * 100.0) / idadePessoas.size();
    
    
  }
  

  /** Exibe relatório na tela do usuário. */
  public void exibir() {
    StringBuilder stringBuilder = new StringBuilder();
    String newLine = System.lineSeparator();

    StringBuilder frase = stringBuilder
        .append("----- Quantidade -----" + newLine)
        .append("menores: " + this.quantCriancas + newLine)
        .append("adultas: " + this.quantAdultos + newLine)
        .append("a partir de 50: " + this.quantIdosos + newLine)
        .append("----- Percentual -----" + newLine)
        .append("menores: " + decimalF.format(this.porcentcriancas) + "%" + newLine)
        .append("adultas: " + decimalF.format(this.porcentAdultos) + "%" + newLine)
        .append("a partir de 50: " + decimalF.format(this.porcentIdosos) + "%" + newLine + newLine)
        .append("TOTAL: " + this.idadePessoas.size());

    System.out.print(frase);

  }

}
