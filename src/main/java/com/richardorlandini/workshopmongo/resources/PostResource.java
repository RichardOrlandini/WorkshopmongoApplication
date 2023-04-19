package com.richardorlandini.workshopmongo.resources;

import com.richardorlandini.workshopmongo.domain.Post;
import com.richardorlandini.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.richardorlandini.workshopmongo.resources.util.URL;
import com.richardorlandini.workshopmongo.services.PostService;

import java.util.Date;
import java.util.List;




@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value="/titlesearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


}
