package crudspringmysql.demo.infrastruture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import crudspringmysql.demo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    List<User> findByEmail(String email);

    @Query(value = "SELECT u FROM User u ORDER BY u.id ASC")
    List<User> orderByIdAsc();

    @Query(value = "SELECT u FROM User u ORDER BY u.id DESC")
    List<User> orderByIdDesc();
}
