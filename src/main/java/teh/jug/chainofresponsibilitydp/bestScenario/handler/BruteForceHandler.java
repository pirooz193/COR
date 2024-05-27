package teh.jug.chainofresponsibilitydp.bestScenario.handler;

import org.springframework.stereotype.Component;

@Component
public class BruteForceHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String handle(String userCredentials, String requestData, String userIP) {
        if (isBruteForceAttempt(userIP)) {
            return "Too many failed attempts";
        } else if (nextHandler != null) {
            return nextHandler.handle(userCredentials, requestData, userIP);
        }
        return "Brute force check passed";
    }

    private boolean isBruteForceAttempt(String userIP) {
        // Brute force attempt detection logic
        return false; // placeholder
    }
}