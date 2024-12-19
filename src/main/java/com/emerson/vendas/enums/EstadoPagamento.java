package com.emerson.vendas.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento(int cod, String Descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) throws IllegalAccessException {

        if(cod == null){
            return null;
        }

        for(EstadoPagamento x : EstadoPagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalAccessException("Id inválido: " + cod);
    }
}
