package br.anhembi.spring02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id // indica Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1,2,3,...
    private int cod;
    private String name;
    private double value;

    @ManyToOne
    @JoinColumn(name = "id_seller")
    @JsonIgnoreProperties("products")
    private Seller seller;
}
