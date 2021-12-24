package system_patterns;

import system_patterns.orm.Connect;
import system_patterns.orm.entities.user.User;
import system_patterns.registry.Registry;
import system_patterns.registry.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Connect.INSTANCE.getConnection()) {
            Registry registry = Registry.getInstance(connection);
            userOperations(registry.findService("userService", UserService.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void userOperations(UserService userService) {
        insertUser(new User(1L, "user1", "user1"), userService);
        updateUser(new User(1L, "user2", "user2"), userService);
        deleteUser(1L, userService);
    }

    private static void insertUser(User user, UserService userService) {
        userService.insertUser(user);
        userService.commit();
        Optional<User> user1 = userService.findById(user.getId());
        System.out.println(user1.isPresent() ? user1.get() : "User not found");
    }

    private static void updateUser(User user, UserService userService) {
        userService.updateUser(user);
        userService.commit();
        Optional<User> user1 = userService.findById(user.getId());
        System.out.println(user1.isPresent() ? user1.get() : "User not found");
    }

    private static void deleteUser(long id, UserService userService) {
        userService.deleteUser(id);
        userService.commit();
        Optional<User> user1 = userService.findById(id);
        System.out.println(user1.isPresent() ? user1.get() : "User not found");
    }
}
