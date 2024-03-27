package com.shopify.shopifyapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private String confirmationNumber;


    @JsonProperty("jsonPropertyName")
    private String testAttribute;
}
