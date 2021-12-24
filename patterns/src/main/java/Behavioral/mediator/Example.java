package Behavioral.mediator;

public class Example {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();
        User user = new User("user1", mediator);
        user.sendMessage("hello");
    }
}
