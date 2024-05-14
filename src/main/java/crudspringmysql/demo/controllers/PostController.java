package crudspringmysql.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crudspringmysql.demo.infrastruture.repositories.PostRepository;
import crudspringmysql.demo.models.Post;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*") // ===== ACTIVAR A COMUNICAÇÃO COM O CLIENTE =====
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/")
    public Post cadastrar(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/")
    public Post editar(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        postRepository.deleteById(id);
    }

    @GetMapping("/")
    public Iterable<Post> listar() {
        return postRepository.findAll();
    }
}
