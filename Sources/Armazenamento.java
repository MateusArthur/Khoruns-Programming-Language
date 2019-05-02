import java.util.*;

class Armazenamento{
	private List<Inteiro> inteiros = new ArrayList<Inteiro>();


	public void setInteiro(String n, int c){
		Inteiro aux = new Inteiro();
		
		aux.setNome(n);
		aux.setConteudo(c);

		inteiros.add(aux);
	}

	//Busca a variravel informada no parametro no armazenamento
	public Inteiro getInteiro(String n){
		for(int i = 0; i < this.inteiros.size(); i++){
			
			if(this.inteiros.get(i).getNome().equals(n)){
				return this.inteiros.get(i);		
			}
		}		
			
		return null;
	}	
}
