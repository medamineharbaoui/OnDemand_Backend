package tn.homejek.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.homejek.model.User;
import tn.homejek.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public User authenticate(String username, String password) {
        User logged = userRepository.findUserByUsername(username);
        if (bCryptPasswordEncoder.matches(password, logged.getPassword())) {
            return logged;
        }
        return null;
    }

    @Override
    public User signup(User us) {
        User testEmail = userRepository.findUserByEmail(us.getEmail());
        User testUsername = userRepository.findUserByUsername(us.getUsername());
        if (testEmail == null && testUsername == null) {
            String encodedPassword = bCryptPasswordEncoder.encode(us.getPassword());
            us.setPassword(encodedPassword);
            return userRepository.save(us);
        } else {
            return null;
        }
    }

    @Override
    public User update(User us) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User verifyUsernameAvailable(String username) {
        return null;
    }

    @Override
    public User verifyEmailAvailable(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Boolean userNameExist(String userName) {
        User res = userRepository.findUserByUsername(userName);
        return res == null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
