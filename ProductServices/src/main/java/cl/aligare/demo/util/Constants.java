package cl.aligare.demo.util;

public class Constants {

	// Spring Security
	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";

	// JWT

	public static final String ISSUER_INFO = "https://www.aligare.cl/";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 300_000; 
	
	// Constantes de respuesta rest
	
	public static final long COD_RES_OK = 0L;
	public static final String MSJE_RES_OK = "OK";
	public static final long COD_RES_NOK = -1L;
	public static final String MSJE_RES_NOK = "NOK";

}
