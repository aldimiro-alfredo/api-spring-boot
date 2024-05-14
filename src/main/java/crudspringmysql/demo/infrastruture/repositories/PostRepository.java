package crudspringmysql.demo.infrastruture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import crudspringmysql.demo.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    //@Query("SELECT posts.id,posts.title,posts.body, users.name FROM posts JOIN user as users")
    //List<Object[]> findPostByUsers();

}
