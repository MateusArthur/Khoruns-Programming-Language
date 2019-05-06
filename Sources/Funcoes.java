class Funcoes 
{
	public static boolean palavraValida(String pal) 
	{
		int i = 0;
		while(i < pal.length())
		{
			char x = pal.charAt(i);
			if(x != 'a' && x != 'b' && x != 'c' && x != 'd' && x != 'e' && x != 'f' && x != 'g' && x != 'h' && x != 'i' && x != 'j' && x != 'k' && x != 'l' && x != 'm' && x != 'n' && x != 'o' && x != 'r' && x != 'p' && x != 'q' && x != 't' && x != 'u' && x != 'v' && x != 'w' && x != 'x' && x != 'y' && x != 'z' && x != '_') 
			{	
				return false;
			}
			i++;
		}
		return true;
	}
	public static int posicaoLivre(int v[]) {
		for(int x = 0; x < v.length; x++) {
			if(v[x] == -1)
				return x;
		}
		return -1;
	}
	public static int[] limparVetor(int v[]) {
		for(int x = 0; x < v.length; x++) {
			v[x] = 0;
		}
		return v;
	}
	public static int[] iniciarVetor(int v[]) {
		for(int x = 0; x < v.length; x++) {
			if(v[x] == 0)
				v[x] = -1;
		}
		return v;
	}
	public static boolean verComparacao(int v[]) {
		for(int x = 0; x < v.length; x++) {
			if(v[x] == 0)
				return false;
		}
		return true;
	}
	public static boolean vetorIniciado(int v[]) {
		for(int x = 0; x < v.length; x++) {
			if(v[x] != 0)
				return true;
		}
		return false;
	}
}