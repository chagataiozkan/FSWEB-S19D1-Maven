package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fruit", schema = "fsweb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
