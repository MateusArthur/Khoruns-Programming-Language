import java.util.*;

class Armazenamento{
	private List<Float> floats = new ArrayList<Float>();

	//Cria um float e armazena no armazenamento.
	public void setFloat(String n, double c){
		Float aux = new Float();

		aux.setNome(n);
		aux.setConteudo(c);

		floats.add(aux);
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
