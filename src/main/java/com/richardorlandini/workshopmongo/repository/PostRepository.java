package com.richardorlandini.workshopmongo.repository;

import com.richardorlandini.workshopmongo.domain.Post;
import com.richardorlandini.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
    // buscando o tile com like e ignorando letras maisculas e minusculas.
}
