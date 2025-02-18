package com.emerson.vendas.services.exceptions;

public class DataIntegrityException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    // Construtor que envia a mensagem de erro.
    public DataIntegrityException(String msg){
        super(msg);
    }
    //  Envia a causa do erro.
    public DataIntegrityException(String msg, Throwable cause){
        super(msg, cause);
    }
}
