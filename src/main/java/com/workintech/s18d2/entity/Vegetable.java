package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vegetable", schema = "fsweb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Boolean grownOnTree;

    public boolean isGrownOnTree() {
        return grownOnTree;
    }

    public void setGrownOnTree(boolean grownOnTree) {
        this.grownOnTree = grownOnTree;
    }
}