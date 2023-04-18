package com.richardorlandini.workshopmongo.resources;

import com.richardorlandini.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /*/ResponseEntity -> encapsular toda uma estrutura necessaria para retornamos respostas http, com possiveis cabeçalhos
     possiveis erros  e etc. ex: public ResponseEntity<List<User>> findAll()
     na hora de retornarmos o metodo, chamamos novamente :
             return ResponseEntity.ok().body(list);
        Definindo o status de Ok, e jogando no corpo da resposta nossa list.
    */
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
