import java.util.*;
/*
	Ler antes de fazer a sting;

									var    tamanho da string
	a string será criada assim: new string[25];

	logo string pode ter tamanho 25, ou ser um vetor de 25 indices vamos utiliza vetor de char para fazer a string
*/
class Armazenamento{
	//Array para armazenar as variaveis tipo inteiro declaradas no arquivo .kh.
	private List<Inteiro> inteiros = new ArrayList<Inteiro>();

	//Array para armazenar as variaveis tipo float declaradas no arquivo .kh.
	private List<Float> floats = new ArrayList<Float>();

	//Cria um inteiro e armazena no armazenamento.
	public void setInteiro(String n, int c){
		Inteiro aux = new Inteiro();
		
		aux.setNome(n);
		aux.setConteudo(c);

		inteiros.add(aux);
	}

	//Cria um float e armazena no armazenamento.
	public void setFloat(String n, double c){
		Float aux = new Float();
		
		aux.setNome(n);
		aux.setConteudo(c);

		floats.add(aux);
	}

	//Busca a variravel informada no parametro no armazenamento.
	public Inteiro getInteiro(String n){
		

		for(int i = 0; i < this.inteiros.size(); i++){

			if(this.inteiros.get(i).getNome().equals(n)){
				return this.inteiros.get(i);		
			}
		}		
		return null;
	}

	//Busca a variravel informada no parametro no armazenamento.
	public Float getFloat(String n){
		for(int i = 0; i < this.floats.size(); i++){
			
			if(this.floats.get(i).getNome().equals(n)){
				return this.floats.get(i);		
			}
		}		
			
		return null;
	}	

}
