class Float extends Variaveis{
  private int f_Conteudo()

  //Sets.
  public int setFloat(int f){
    this.f_Conteudo = f;
  }

  //Gets.
  public void getFloat(){
    return this.f_Conteudo;
  }

  //Metodos.
  public void criaFloat(int f, String n){
    this.setFloat(f);
    this.setNome(n);
  }


}
