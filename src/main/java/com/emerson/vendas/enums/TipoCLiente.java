package com.emerson.vendas.enums;

public enum TipoCLiente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2,"Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCLiente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }



    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static TipoCLiente toEnum(Integer cod) throws IllegalAccessException {

        if(cod == null){
            return null;
        }

        for(TipoCLiente x : TipoCLiente.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalAccessException("Id inválido: " + cod);
    }
}
