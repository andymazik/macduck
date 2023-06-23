package com.javarush.macduck.controller;

import com.javarush.macduck.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;



@Controller
public class OrderController {

    private final OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        IReactiveDataDriverContextVariable iReactiveDataDriverContextVariable =
                new ReactiveDataDriverContextVariable(orderRepository.findAll(), 1);

        model.addAttribute("orders", iReactiveDataDriverContextVariable);

        //model.addAttribute("orders", orderRepository.findAll());

        return "index";
    }


}
