package trie;

import java.io.Serializable;

/**
 * Estrutura Trie. 
 * Possui como atributo um array de Trie, com 26 posições.
 * Cada uma dessas posições equivale a uma letra do alfabeto.
 * 
 * @author Danilo Moura
 */
public class Trie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Trie[]  noTrie = new Trie[26];
	public  boolean fim    = false;

	/**
	 * Método utilizado para adicionar uma palavra à Trie.
	 * @param letras É um array de caracteres. Equivalente a uma palavra.
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
	 * Verifica se uma palavra já existe na trie. 
	 * @param letras É um array de caracteres. Equivalente a uma palavra.
	 * @return <code>True</code> caso a palavra já exista na trie; <code>False</code> caso a palavra não exista na trie.
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
