package system_patterns.orm.entities.user;

import java.sql.Connection;

public class UserMapperFactory {
    private UserMapperFactory() {

    }

    public static UserMapper createUserMapper(Connection connection) {
        return new UserMapper(connection);
    }
}
