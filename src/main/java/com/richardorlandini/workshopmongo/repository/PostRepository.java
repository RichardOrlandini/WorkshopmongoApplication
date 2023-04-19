package com.richardorlandini.workshopmongo.repository;

import com.richardorlandini.workshopmongo.domain.Post;
import com.richardorlandini.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // o regex e o valor 0, e o 1 parametro do metodo abaixo
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
    // buscando o tile com like e ignorando letras maisculas e minusculas.
    // Spriong data gera a consulta automaticamente.

}
