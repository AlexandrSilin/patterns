package system_patterns.orm.entities.user;

public class UserUnitOfWorkFactory {
    private UserUnitOfWorkFactory() {

    }

    public static UserUnitOfWork createUnitOfWork(UserMapper mapper) {
        return new UserUnitOfWork(mapper);
    }
}
