class Float extends Variaveis{
  private float f_Conteudo;

  //Sets.
  public void setFloat(int f){
    this.f_Conteudo = f;
  }

  //Gets.
  public float getFloat(){
    return this.f_Conteudo;
  }

  //Metodos.
  public void criaFloat(int f, String n){
    this.setFloat(f);
    this.setNome(n);
  }


}
