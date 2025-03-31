package com.projetoudemy.coursespringboot.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code; // atributo para receber valores numericos

    private OrderStatus(int code){ //Construtor para iniciar com os codigos ou valores numericos ja carregados
        this.code = code;
    }

    public int getCode(){ //metodo para tornar visivel para o mundo exterior ou para fora do banco de dados na leitura
        return code;
    }

    //Metodo statico para converter um valor numerico para um tipo enumerado, metodo estatico funcionara sem precisar instancialos
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){ //percorre todos os valores possiveis do OrderStatus e para cada um deles testar se o codigo é correspondente e retornalo
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code"); // Exceção para caso o valor do code não for correspondente aos valores disponiveis
    }
}
