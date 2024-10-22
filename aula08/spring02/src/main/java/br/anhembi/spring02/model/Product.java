package br.anhembi.spring02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
