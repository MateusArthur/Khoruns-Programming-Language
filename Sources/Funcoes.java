import java.io.*;
import java.util.*;

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
}