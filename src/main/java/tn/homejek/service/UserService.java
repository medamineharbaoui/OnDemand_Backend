package tn.homejek.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tn.homejek.model.User;

import java.util.List;

public interface UserService {
    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;

    User authenticate(String login, String password);

    User signup(User us);

    User update(User us);

    User getUser(String username);

    User verifyUsernameAvailable(String username);

    User verifyEmailAvailable(String email);

    List<User> getAllUsers();

    Boolean userNameExist(String userName);

    void deleteUser(Long id);
}
