package fun.caspar.service;

import fun.caspar.model.User;

import java.util.List;

public interface IUserService {
    List<User> list();

    List<User> findByUsername(String username);

    User findUser(String username);

    User getUser(Integer id);

    Integer sava(String username, String password);

    int delete(Integer id);
}
