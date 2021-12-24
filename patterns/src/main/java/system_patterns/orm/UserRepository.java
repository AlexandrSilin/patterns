package system_patterns.orm;

import system_patterns.orm.entities.user.*;

import java.sql.Connection;
import java.util.Optional;

public class UserRepository {
    private final UserMapper mapper;
    private UserUnitOfWork unit;

    UserRepository(Connection connection) {
        this.mapper = UserMapperFactory.createUserMapper(connection);
        this.unit = UserUnitOfWorkFactory.createUnitOfWork(this.mapper);
    }

    public void beginTransaction() {
        this.unit = UserUnitOfWorkFactory.createUnitOfWork(this.mapper);
    }

    public Optional<User> findById(Long id) {
        return mapper.findById(id);
    }

    public void insert(User user) {
        unit.registerNew(user);
    }

    public void update(User user) {
        unit.registerUpdate(user);
    }

    public void delete(User user) {
        unit.registerDelete(user);
    }

    public void commit() {
        unit.commit();
    }
}
