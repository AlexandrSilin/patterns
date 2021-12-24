package system_patterns.registry;

import system_patterns.orm.UserRepository;
import system_patterns.orm.UserRepositoryFactory;
import system_patterns.orm.entities.user.User;

import java.sql.Connection;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(Connection connection) {
        this.userRepository = UserRepositoryFactory.create(connection);
    }

    public void insertUser(User user) {
        userRepository.insert(user);
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void beginTransaction() {
        userRepository.beginTransaction();
    }

    public void commit() {
        userRepository.commit();
    }
}
