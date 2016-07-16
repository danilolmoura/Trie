package trie;
//TODO: MELHORAR MÉTODOS DA CLASSE
public class ManipulaCaracteres {
	/**
	 * Variavéis de caracteres especiais
	 */
	private static String s_strOld = "áãâàéêíóõôúçñ",
						  s_strNew = "aaaaeeioooucn";
	
	/**
	 * Regex realização de ajustes no texto
	 */
	private static final String s_strRegExpCaracteres    = "[^( a-zA-Z)]",
								 s_strRegExpEmptyLines   = "\\n\\s\\n",
								 s_strRegExpNumeros      = "[(0-9)]",
								 s_strRegExpEspacoTriplo = "\\s\\s\\s";
	
	private String strTextoConvertido;
	
	/**
	 * Construtor da classe. 
	 * @param strTextao String contendo o texto que deseja-se ajustar.
	 */
	public ManipulaCaracteres( String strTextao )
	{
		strTextoConvertido = ajustaTexto( strTextao );
	}
	
	/**
	 * Pega o texto após ser ajustado
	 * @return String com o texto ajustado
	 */
	public String getTextoConvertido() {
		return strTextoConvertido;
	}
		
	private String converteLetrasEspeciais( String strTextao ) 
	{
		for ( int i = 0; i < s_strNew.length(); i++ )
			strTextao = strTextao.replace( String.valueOf( s_strOld.charAt(i) ), String.valueOf( s_strNew.charAt( i ) ) );
		
		return strTextao;
	}
	
	private String ajustaTexto( String strTextao )
	{
		String strPalavra01 = strTextao.toLowerCase();
		String strPalavra02 = converteLetrasEspeciais( strPalavra01 				  );
		String strPalavra1  = strPalavra02.replaceAll( s_strRegExpEmptyLines,     ""  );
		String strPalavra2  = strPalavra1.replaceAll ( s_strRegExpNumeros,        ""  );
		String strPalavra3  = strPalavra2.replaceAll ( s_strRegExpCaracteres,     ""  );
		String strPalavra4  = strPalavra3.replaceAll ( s_strRegExpEspacoTriplo,   " " );
		String strPalavra5  = strPalavra4.replaceAll ( "s_strRegExpEspacoTriplo", " " );
		
		return strPalavra5.trim();
	}
	
	public static char[] removePrimeiraLetra( char[] letras )
	{
		char[] ArrChar = new char[letras.length - 1];
		
		for( int i = 0; i < ArrChar.length; i++ ) 
			ArrChar[i] = letras[i + 1];
		
		return ArrChar;
	}
}