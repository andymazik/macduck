package com.javarush.macduck.repository;

import com.javarush.macduck.entity.Order;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReactiveOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public ReactiveOrderRepository() {
        orders.add(new Order("БигМак + Ср.Картошка + Кола", 697));
        orders.add(new Order("Деревня + МакЧикен + Ролл с тунцом + Ванил.Коктейль", 701));
        orders.add(new Order("ХэппиМил + Бол.Картошка х2", 702));
        orders.add(new Order("Мороженое х3 + Баскет с байтсами + Воппер", 704));
        orders.add(new Order("Клуб.коктейль х2 + Чизбургер х3", 705));
    }

    @Override
    public Flux<Order> findAll() {
        return Flux.fromIterable(orders).delayElements(Duration.ofSeconds(3));
    }
}
