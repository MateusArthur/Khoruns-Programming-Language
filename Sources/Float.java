class Float extends Variaveis{
  private double f_Conteudo;

  //Sets.
  public void setConteudo(double f){
    this.f_Conteudo = f;
  }

  //Gets.
  public double getConteudo(){
    return this.f_Conteudo;
  }

  //Metodos.
  public void criaFloat(double f, String n){
    this.setConteudo(f);
    this.setNome(n);
  }
}
