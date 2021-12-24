package system_patterns.orm.entities.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {
    private final Map<Long, User> identityMap = new HashMap<>();
    private final PreparedStatement selectUser;
    private final PreparedStatement insertUser;
    private final PreparedStatement deleteUser;
    private final PreparedStatement updateUser;

    UserMapper(Connection connection) {
        try {
            this.selectUser = connection.prepareStatement("select id, username, password from users where id = ?");
            this.insertUser = connection.prepareStatement("insert into users(id, username, password) values (?, ?, ?)");
            this.deleteUser = connection.prepareStatement("delete from users where id = ?");
            this.updateUser = connection.prepareStatement("update users set username = ?, password = ? where id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet resultSet = selectUser.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.empty();
    }

    public void insertUser(User user) {
        try {
            insertUser.setLong(1, user.getId());
            insertUser.setString(2, user.getLogin());
            insertUser.setString(3, user.getPassword());
            insertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            updateUser.setString(1, user.getLogin());
            updateUser.setString(2, user.getPassword());
            updateUser.setLong(3, user.getId());
            updateUser.executeUpdate();
            identityMap.put(user.getId(), user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            deleteUser.setLong(1, user.getId());
            deleteUser.executeUpdate();
            identityMap.remove(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
