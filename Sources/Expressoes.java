class Expressoes{
  private int a, b;

  public void calcula(String[] vetor, Inteiro var){
    //a = vetor[0].charAt(0);
    a = Integer.parseInt(vetor[0]);//Passar o valor do Indice [0] do Vetor de Character para Inteiro.
    b = Integer.parseInt(vetor[2]);//Passar o valor do Indice [2] do Vetor de Character para Inteiro.

    if(vetor[1].equals("+")){
      var.setConteudo(this.soma(a, b));
    }

    else if(vetor[1].equals("-")){
      var.setConteudo(this.subtrai(a, b));
    }

    else if(vetor[1].equals("*")){
      var.setConteudo(this.multiplica(a, b));
    }

    else if(vetor[1].equals("/")){
      var.setConteudo(this.divide(a, b));
    }

    else{
      System.out.println("ERROR");
    //  return null;
    }
  }


  public int soma(int a, int b){
      return a + b;
  }


  public int subtrai(int a, int b){
      return a + b;
  }


  public int multiplica(int a, int b){
      return a + b;
  }


  public int divide(int a, int b){
      return a + b;
  }
}
