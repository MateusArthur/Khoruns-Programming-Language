class Expressoes{
  public int calcula(int oa, int ob, String op){
    if(op.equals("+")){
      return this.soma(oa, ob);
    }

    else if(op.equals("-")){
      return this.subtrai(oa, ob);
    }

    else if(op.equals("*")){
      return this.multiplica(oa, ob);
    }

    else if(op.equals("/")){
      return this.divide(oa, ob);
    }

    else if(op.equals("%")){
      return this.modulo(oa, ob);
    }

    else{
      System.out.println("ERROR");
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

  public int modulo(int a, int b){
    return a % b;
  }


}
