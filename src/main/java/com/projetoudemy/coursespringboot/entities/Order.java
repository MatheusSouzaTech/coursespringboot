package com.projetoudemy.coursespringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    //Associação a classe User
    @ManyToOne//Instrui a JPA a transforma o cliente em uma chave estrangeira usasse esta anotation
    @JoinColumn(name = "cliente_id") //Define o nome que a chave estrangeira ira ter na outra tabela
    private User client;

    public Order() {}

    public Order(Long id , Instant moment, User client){
        this.id = id;
        this.moment = moment;
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
