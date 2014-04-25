package br.bus.recrutamento.exception;

public class ClienteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3341591207166511194L;

	private static final String ERRO = "Erro ao manter cliente.";
	
	public ClienteException(Throwable e){
		super(e.getMessage(), e);
	}
	
	public ClienteException(String message){
		super(message);
	}
	
	public ClienteException(){
		super(ERRO);
	}
}
