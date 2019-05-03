//Classe pai para todos os tipos de variaveis.
class Variaveis{
	protected String nome;
	protected String local; // Nome da função se estiver dentro de uma função ou "global" se estiver fora de uma função

	//Sets.
	public void setNome(String n){
		this.nome = n;		
	}

	public void setLocal(String n) {
		this.local = n;
	}

	//Gets.
	public String getNome(){
		return this.nome;
	}

	public String getLocal() {
		return this.local;
	}
}
