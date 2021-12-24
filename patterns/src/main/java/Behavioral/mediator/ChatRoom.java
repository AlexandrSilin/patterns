package Behavioral.mediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] "
                + user.getUserName() + ": " + message);
    }
}
