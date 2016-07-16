package trie;

import java.io.Serializable;

/**
 * Estrutura Trie. 
 * Possui como atributo um array de Trie, com 26 posi��es.
 * Cada uma dessas posi��es equivale a uma letra do alfabeto.
 * 
 * @author Danilo Moura
 */
public class Trie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Trie[]  noTrie = new Trie[26];
	public  boolean fim    = false;

	/**
	 * M�todo utilizado para adicionar uma palavra � Trie.
	 * @param letras � um array de caracteres. Equivalente a uma palavra.
	 */
	public void add( char[] letras ) {
		int numChar = 0;
			
		numChar = Character.getNumericValue( letras[0] ) - 10;
		
		if( letras.length > 1 )
		{
			if( noTrie[numChar] == null )
				noTrie[numChar] = new Trie();
			
			noTrie[numChar].add( ManipulaCaracteres.removePrimeiraLetra( letras ) );
		}
		else if( letras.length == 1 )
		{
			if( noTrie[numChar] == null )
				noTrie[numChar] = new Trie();
			
			fim = true;
		}
	}
	
	/**
	 * Verifica se uma palavra j� existe na trie. 
	 * @param letras � um array de caracteres. Equivalente a uma palavra.
	 * @return <code>True</code> caso a palavra j� exista na trie; <code>False</code> caso a palavra n�o exista na trie.
	 */
 	public boolean contemPalavra( char[] letras ) {
 		int numChar = Character.getNumericValue( letras[0] ) - 10;
		
		if( letras.length > 1 )
		{
			if( noTrie[numChar] != null )
				return noTrie[numChar].contemPalavra( ManipulaCaracteres.removePrimeiraLetra( letras ) );

			return false;
		}
		else
		{
			if( noTrie[numChar] != null && fim )
				return true;
			
			return false;
		}
	}
}
