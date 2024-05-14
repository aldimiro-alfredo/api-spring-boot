package crudspringmysql.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudspringmysql.demo.infrastruture.repositories.UserRepository;
import crudspringmysql.demo.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Iterable<User> orderByIdAsc() {
        return userRepository.orderByIdAsc();
    }

    public Iterable<User> orderByIdDesc() {
        return userRepository.orderByIdDesc();
    }

}
