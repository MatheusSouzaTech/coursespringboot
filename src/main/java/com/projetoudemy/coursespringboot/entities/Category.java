package com.projetoudemy.coursespringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category") // Define o nome da tabela no banco de dados como "tb_category"
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id // Indica que o campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de auto incremento para o ID
    private Long id;

    private String name;

    // Ignora a serialização do campo 'products' para evitar loop infinito em respostas JSON
    @JsonIgnore
    @ManyToMany(mappedBy = "categories") // Relacionamento muitos-para-muitos, mapeado pelo atributo 'categories' na entidade Product
    private Set<Product> products = new HashSet<>();

    // Construtor padrão (necessário para o JPA)
    public Category() {}

    // Construtor com argumentos
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    // Implementação de equals e hashCode baseada apenas no ID, para garantir consistência entre entidades
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
