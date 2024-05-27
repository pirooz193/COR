package teh.jug.chainofresponsibilitydp.bestScenario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teh.jug.chainofresponsibilitydp.bestScenario.handler.*;

@Configuration
public class HandlerConfig {

    @Autowired
    private AuthenticationHandler authenticationHandler;

    @Autowired
    private AuthorizationHandler authorizationHandler;

    @Autowired
    private ValidationHandler validationHandler;

    @Autowired
    private BruteForceHandler bruteForceHandler;

    @Autowired
    private CachingHandler cachingHandler;

    @Bean
    public Handler chainOfHandlers() {
        authenticationHandler.setNext(authorizationHandler);
        authorizationHandler.setNext(validationHandler);
        validationHandler.setNext(bruteForceHandler);
        bruteForceHandler.setNext(cachingHandler);
        return authenticationHandler;
    }
}