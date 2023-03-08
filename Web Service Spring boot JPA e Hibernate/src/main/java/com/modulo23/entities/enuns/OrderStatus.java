package com.modulo23.entities.enuns;

public enum OrderStatus {

    WAITING_PAYMENT(1),       //?    Aguardando Pagamento
    PAID(2),                  //?    Pago
    SHIPPED(3),               //?    Enviado
    DELIVERED(4),             //?    Entregue
    CANCELED(5);              //?    Cancelado

    private int code;         //?    Código do tipo enumerado

    //-----------------------------------   Construtor   ---------------------------------------------------------------
    private OrderStatus(int code) {
        this.code = code;
    }
    //-----------------------------------   Methods   ------------------------------------------------------------------

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code | Código de OrderStatus inválido");
    }
}
