package com.shopify.shopifyapi.controller;

import com.shopify.shopifyapi.model.Order;
import com.shopify.shopifyapi.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {

        log.info("New Placed Order {}", order);
        orderService.save(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
