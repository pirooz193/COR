package teh.jug.chainofresponsibilitydp.bestScenario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teh.jug.chainofresponsibilitydp.bestScenario.handler.Handler;

@RestController
public class OrderController {

    private final Handler chainOfHandlers;

    @Autowired
    public OrderController(Handler chainOfHandlers) {
        this.chainOfHandlers = chainOfHandlers;
    }

    @PostMapping("/createOrder")
    public String createOrder(@RequestParam String userCredentials, @RequestBody String requestData, @RequestParam String userIP) {
        return chainOfHandlers.handle(userCredentials, requestData, userIP);
    }
}