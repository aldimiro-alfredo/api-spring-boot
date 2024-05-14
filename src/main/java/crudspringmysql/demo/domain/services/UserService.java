package crudspringmysql.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import crudspringmysql.demo.infrastruture.repositories.UserRepository;
import crudspringmysql.demo.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> saveUser(User user) {

        if (user.getName().equals("") || user.getName().isEmpty()) {
            return new ResponseEntity<>("O campo nome é obrigatório", HttpStatus.BAD_REQUEST);
        } else if (user.getEmail().equals("") || user.getEmail().isEmpty()) {
            return new ResponseEntity<>("O campo email é obrigatório", HttpStatus.BAD_REQUEST);
        }

        var userSaved = userRepository.save(user);

        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateUser(User user) {

        if (user.getName().equals("") || user.getName().isEmpty()) {
            return new ResponseEntity<>("O campo nome é obrigatório", HttpStatus.BAD_REQUEST);
        } else if (user.getEmail().equals("") || user.getEmail().isEmpty()) {
            return new ResponseEntity<>("O campo email é obrigatório", HttpStatus.BAD_REQUEST);
        }

        var userUpdated = userRepository.save(user);

        return new ResponseEntity<>(userUpdated, HttpStatus.CREATED);
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
