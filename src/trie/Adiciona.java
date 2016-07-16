package trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Esta classe testa a adição de palavras na trie.
 * 	 
 * @author Danilo Moura
 */
public class Adiciona {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		StringBuilder strTextoCompleto = new StringBuilder();
		
		try {
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( new FileInputStream( "os_lusiadas2.txt"), "UTF-8" ) );
			
			String strLinha = bufferedReader.readLine();
			while ( strLinha != null ) {
				strTextoCompleto.append( strLinha + " " );
				strLinha = bufferedReader.readLine();
			}
		} 
		catch( UnsupportedEncodingException e ) {
			e.printStackTrace();
		} 
		catch( FileNotFoundException e ) {
			e.printStackTrace();
		} 
		catch( IOException e ) {
			e.printStackTrace();
		}

		ManipulaCaracteres cdc = new ManipulaCaracteres( strTextoCompleto.toString() );
		String[] arrPalavras   = cdc.getTextoConvertido().split( " " );
		
		
		try {
			FileOutputStream   fOutStream   = new FileOutputStream( "trie.dat" );
			ObjectOutputStream objOutStream = new ObjectOutputStream( fOutStream );
			
			Trie raiz = new Trie();
			//Palavra que será adicionada
			for( int i = 0; i < arrPalavras.length ; i++ ) {
				System.out.println( arrPalavras[i]);
				if( raiz.contemPalavra( arrPalavras[i].toCharArray() ) )
					continue;
				
				raiz.add( arrPalavras[i].toCharArray() );
			}
			
			objOutStream.writeObject( raiz );
			objOutStream.flush();
			objOutStream.close();
		} 
		catch( FileNotFoundException e ) {
			e.printStackTrace();
		} 
		catch( IOException e ) {
			e.printStackTrace();
		}
	}
}
