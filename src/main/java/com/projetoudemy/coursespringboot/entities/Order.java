package com.projetoudemy.coursespringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoudemy.coursespringboot.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "orders") // Define o nome da tabela como "orders" no banco de dados
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define o ID com geração automática (auto incremento)
    private Long id;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT"
    )
    // Formata a data no padrão ISO 8601 como string no formato UTC ao serializar para JSON
    private Instant moment;

    private Integer orderStatus; // Status do pedido (usando enum)

    // Associação com a entidade User (muitos pedidos para um cliente)
    @ManyToOne // Indica o relacionamento Many-to-One entre Order e User
    @JoinColumn(name = "cliente_id") // Nome da coluna da chave estrangeira na tabela de pedidos
    private User client;

    // Construtor padrão (necessário para JPA)
    public Order() {}

    // Construtor com argumentos
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        //Atribuindo o objeto orderStatus para a classe Order
        setOrderStatus(orderStatus); // Atribui o status do pedido
        this.client = client;           // Atribui o cliente associado
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        //Convertendo o numero inteiro para o objeto OrderStatus
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        //pegando o numero inteiro correspondente ao OrderStatus
        if(orderStatus != null){
        this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    // Implementação de equals e hashCode baseada apenas no ID
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
