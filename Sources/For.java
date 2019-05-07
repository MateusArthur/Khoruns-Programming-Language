import java.util.*;

class For {
	private int iterador;
	private int loops;
	private ArrayList<Variaveis> variaveis = new ArrayList<Variaveis>();

	public void setIterador(int x) {
		this.iterador = x;
	}
	public void setLoops(int x) {
		this.loops = x;
	}
	public void setVar(String nome, String local) {
		Variaveis aux = new Variaveis();

		aux.setNome(nome);
		aux.setLocal(local);

		variaveis.add(aux);
	}

	public int getIterador() {
		return this.iterador;
	}
	public int getLoops() {
		return this.loops;
	}
	public String getVar(String nome) {
		for(int i = 0; i < this.variaveis.size(); i++) {
			if(this.variaveis.get(i).getNome().equals(nome)) {
				return this.variaveis.get(i).getNome();
			}
		}
		return null;
	}
}