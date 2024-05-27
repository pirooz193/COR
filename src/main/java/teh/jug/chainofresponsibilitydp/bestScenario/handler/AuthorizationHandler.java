package teh.jug.chainofresponsibilitydp.bestScenario.handler;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String handle(String userCredentials, String requestData, String userIP) {
        if (!authorize(userCredentials)) {
            return "Authorization failed";
        } else if (nextHandler != null) {
            return nextHandler.handle(userCredentials, requestData, userIP);
        }
        return "Authorization passed";
    }

    private boolean authorize(String userCredentials) {
        // Authorization logic
        return true;
    }
}