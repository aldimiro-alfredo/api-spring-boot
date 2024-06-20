package crudspringmysql.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crudspringmysql.demo.infrastruture.repositories.UserRepository;
import crudspringmysql.demo.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional // Se algo der errado teremos um rollback auto
    public ResponseEntity<?> saveUser(User user) {

        if (user.getUsername().equals("") || user.getUsername().isEmpty()) {
            return new ResponseEntity<>("O campo nome é obrigatório", HttpStatus.BAD_REQUEST);
        } else if (user.getEmail().equals("") || user.getEmail().isEmpty()) {
            return new ResponseEntity<>("O campo email é obrigatório", HttpStatus.BAD_REQUEST);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded_pw = encoder.encode(user.getPassword());
        user.setPassword(encoded_pw);

        var userSaved = userRepository.save(user);

        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @Transactional // Se algo der errado teremos um rollback auto
    public ResponseEntity<?> updateUser(User user) {

        if (user.getId() == 0 || user.getId() < 0) {
            return new ResponseEntity<>("O id não existe, informa um id válido!", HttpStatus.BAD_REQUEST);
        } else if (user.getUsername().equals("") || user.getUsername().isEmpty()) {
            return new ResponseEntity<>("O campo nome é obrigatório!", HttpStatus.BAD_REQUEST);
        } else if (user.getEmail().equals("") || user.getEmail().isEmpty()) {
            return new ResponseEntity<>("O campo email é obrigatório!", HttpStatus.BAD_REQUEST);
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
