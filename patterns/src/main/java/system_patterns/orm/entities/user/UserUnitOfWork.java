package system_patterns.orm.entities.user;

import java.util.ArrayList;
import java.util.List;

public class UserUnitOfWork {
    public final List<User> updateUsers = new ArrayList<>();
    public final List<User> deleteUsers = new ArrayList<>();
    private final UserMapper mapper;
    private final List<User> newUsers = new ArrayList<>();

    UserUnitOfWork(UserMapper mapper) {
        this.mapper = mapper;
    }

    public void registerNew(User user) {
        newUsers.add(user);
    }

    public void registerUpdate(User user) {
        updateUsers.add(user);
    }

    public void registerDelete(User user) {
        deleteUsers.add(user);
    }

    private void insert() {
        if (newUsers.size() > 0) {
            for (User user : newUsers) {
                mapper.insertUser(user);
            }
            newUsers.clear();
        }
    }

    private void update() {
        if (updateUsers.size() > 0) {
            for (User user : updateUsers) {
                mapper.updateUser(user);
            }
            updateUsers.clear();
        }
    }

    private void delete() {
        if (deleteUsers.size() > 0) {
            for (User user : deleteUsers) {
                mapper.deleteUser(user);
            }
        }
    }

    public void commit() {
        insert();
        update();
        delete();
    }
}

