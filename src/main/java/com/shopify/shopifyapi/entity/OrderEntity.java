package com.shopify.shopifyapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shopify_order")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "confirmation_name")
    private String confirmationNumber;
}
