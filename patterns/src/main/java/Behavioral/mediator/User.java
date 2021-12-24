package Behavioral.mediator;

public class User {
    private final String userName;
    private final ChatRoomMediator mediator;

    public User(String userName, ChatRoomMediator mediator) {
        this.userName = userName;
        this.mediator = mediator;
    }

    public String getUserName() {
        return userName;
    }

    public void sendMessage(String message) {
        mediator.showMessage(this, message);
    }
}
