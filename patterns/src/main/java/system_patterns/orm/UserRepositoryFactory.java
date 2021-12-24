package system_patterns.orm;

import java.sql.Connection;

public class UserRepositoryFactory {
    private UserRepositoryFactory() {

    }

    public static UserRepository create(Connection connection) {
        return new UserRepository(connection);
    }
}
