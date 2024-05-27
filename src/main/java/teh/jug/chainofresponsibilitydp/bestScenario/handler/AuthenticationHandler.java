package teh.jug.chainofresponsibilitydp.bestScenario.handler;


import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public String handle(String userCredentials, String requestData, String userIP) {
        if (!authenticate(userCredentials)) {
            return "Authentication failed";
        } else if (nextHandler != null) {
            return nextHandler.handle(userCredentials, requestData, userIP);
        }
        return "Authentication passed";
    }

    private boolean authenticate(String userCredentials) {
        // Authentication logic
        return true; // placeholder
    }
}
