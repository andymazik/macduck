package com.javarush.macduck.repository;

import com.javarush.macduck.entity.Order;
import reactor.core.publisher.Flux;

public interface OrderRepository {
    Flux<Order> findAll();
}
