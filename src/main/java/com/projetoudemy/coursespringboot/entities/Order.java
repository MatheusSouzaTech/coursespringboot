package com.projetoudemy.coursespringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoudemy.coursespringboot.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table (name = "orders")
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Entidades
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT") //Garante que o instante seja mostrado no Json como string usar a anotacion @JsonFormat.Shape
    private Instant moment;

    private Integer orderStatus;

    //Associação a classe User
    @ManyToOne//Instrui a JPA a transforma o cliente em uma chave estrangeira usasse esta anotation
    @JoinColumn(name = "cliente_id") //Define o nome que a chave estrangeira ira ter na outra tabela
    private User client;

    public Order() {}

    public Order(Long id , Instant moment,OrderStatus orderStatus, User client){
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus); //executa o processo de conversão de tipos dentro do contrutor
        this.client = client;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Instant getMoment(){
        return moment;
    }

    public void setMoment(Instant moment){
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus); //Convertendo o numero inteiro para o enum orderStatus
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) { // para caso o programador passe um valor nulo para contruir um objeto
            this.orderStatus = orderStatus.getCode();//Fazendo o processo inverso da conversão de um orderStatus para um valor inteiro processo interno
        }
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client){
        this.client = client;
    }

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
