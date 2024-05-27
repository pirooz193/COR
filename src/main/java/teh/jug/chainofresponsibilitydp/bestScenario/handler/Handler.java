package teh.jug.chainofresponsibilitydp.bestScenario.handler;

public interface Handler {
    void setNext(Handler handler);

    String handle(String userCredentials, String requestData, String userIP);
}