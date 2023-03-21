package DAO;

import Model.User;

import java.util.List;

public interface UserDao {

    boolean create(User user);
    List<User> findAll();
    void updateAccount(User user);
    void deleteAccount(int id);

}
