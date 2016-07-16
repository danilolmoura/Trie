package trie;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Esta classe é testa a busca de palavras na trie
 * @author Danilo Moura
 */
public class Busca {

	public static void main(String[] args) {
		
		try {
			FileInputStream   fInStream   = new FileInputStream( "trie.dat" );
			ObjectInputStream objInStream = new ObjectInputStream( fInStream );
			
			Trie raiz2  = (Trie) objInStream.readObject();
			objInStream.close();
			
			System.out.println( raiz2.contemPalavra( "enveja".toCharArray() ) );
			System.out.println( raiz2.contemPalavra( "renato".toCharArray()     ) );
			System.out.println( raiz2.contemPalavra( "os".toCharArray()  ) );
			System.out.println( raiz2.contemPalavra( "gentios".toCharArray()   ) );
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
