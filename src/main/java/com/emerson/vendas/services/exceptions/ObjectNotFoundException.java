package com.emerson.vendas.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    // Construtor que envia a mensagem de erro.
    public ObjectNotFoundException(String msg){
        super(msg);
    }
    //  Envia a causa do erro.
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
