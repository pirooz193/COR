package teh.jug.chainofresponsibilitydp.bestScenario.handler;

import org.springframework.stereotype.Component;

@Component
public class ValidationHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String handle(String userCredentials, String requestData, String userIP) {
        if (!validate(requestData)) {
            return "Validation failed";
        } else if (nextHandler != null) {
            return nextHandler.handle(userCredentials, requestData, userIP);
        }
        return "Validation passed";
    }

    private boolean validate(String requestData) {
        // Data validation logic
        return true; // placeholder
    }
}