package teh.jug.chainofresponsibilitydp.badScenario.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teh.jug.chainofresponsibilitydp.badScenario.service.OrderService;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public String createOrder(@RequestParam String userCredentials, @RequestBody String requestData, @RequestParam String userIP) {
        return orderService.createOrder(userCredentials, requestData, userIP);
    }
}