package com.projetoudemy.coursespringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity //Anotacion do jpa para instruir como que ele vai converter os objetos para o modelo relacional
@Table(name = "users")
public class User implements Serializable {

    // O serialVersionUID não está relacionado ao campo id. Ele é usado apenas para controle de serialização.
    @Serial
    private static final long serialVersionUID = 1L;

    @Id //Definindo o id como id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chave primária com auto incremento
    private Long id;  // O id não deve ser static
    private String name;
    private String email;
    private String phone;
    private String password;

    //Associassão com a classe Order
    @JsonIgnore //ele ignora o campo durante a serialização do mesmo e armazenamento impedindo que se crie um loop jackson dentro do banco quando for chamado
    @OneToMany(mappedBy = "client")//Mapeando o atributo
    private List<Order> orders = new ArrayList<>();

    public User() {}

    // Construtor com parâmetros
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //Get para a lista de pedidos
    public List<Order> getOrders(){
        return orders;
    }

    // hashCode e equals para comparação baseada no ID
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User other = (User) obj;
        return id != null && id.equals(other.id);
    }




}
