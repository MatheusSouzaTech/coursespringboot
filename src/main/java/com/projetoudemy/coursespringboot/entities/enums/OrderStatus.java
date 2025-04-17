package com.projetoudemy.coursespringboot.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code; // Atributo para armazenar o valor numérico associado ao status

    // Construtor para inicializar a enumeração com o código numérico correspondente
    private OrderStatus(int code) {
        this.code = code;
    }

    // Metodo getter para expor o valor numérico do status
    public int getCode() {
        return code;
    }

    // Metodo estático que converte um valor numérico para o tipo enumerado correspondente
    public static OrderStatus valueOf(int code) {
        // Percorre todos os valores possíveis do enum e retorna o que corresponde ao código fornecido
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        // Lança exceção se o código informado não for válido
        throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
    }
}
