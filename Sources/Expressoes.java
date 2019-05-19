class Expressoes{
  private int a, b;

  public int calcula(String oa, String ob, String op){
    //a = vetor[0].charAt(0);
    a = Integer.parseInt(oa);//Passar o valor do Indice [0] do Vetor de Character para Inteiro.
    b = Integer.parseInt(ob);//Passar o valor do Indice [2] do Vetor de Character para Inteiro.

    if(op.equals("+")){
      return this.soma(a, b);
    }

    else if(op.equals("-")){
      return this.subtrai(a, b);
    }

    else if(op.equals("*")){
      return this.multiplica(a, b);
    }

    else if(op.equals("/")){
      return this.divide(a, b);
    }

    else{
      System.out.println("ERROR");
    //  return null;
    }

    return 0;
  }


  public int soma(int a, int b){
      return a + b;
  }


  public int subtrai(int a, int b){
      return a - b;
  }


  public int multiplica(int a, int b){
      return a * b;
  }


  public int divide(int a, int b){
      return a / b;
  }
}
