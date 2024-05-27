package teh.jug.chainofresponsibilitydp.bestScenario.handler;

import org.springframework.stereotype.Component;

@Component
public class CachingHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String handle(String userCredentials, String requestData, String userIP) {
        if (isCached(requestData)) {
            return "Returning cached result";
        } else if (nextHandler != null) {
            return nextHandler.handle(userCredentials, requestData, userIP);
        }
        return "Caching check passed";
    }

    private boolean isCached(String requestData) {
        // Caching logic
        return false; // placeholder
    }
}