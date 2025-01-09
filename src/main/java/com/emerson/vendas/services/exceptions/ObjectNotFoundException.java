package com.emerson.vendas.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    // Construtores que enviam a mensagem de erro.
    public ObjectNotFoundException(String msg){
        super(msg);
    }
    
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
