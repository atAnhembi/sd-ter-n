package br.anhembi.spring01.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.AppUser;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{nome}")
    public String hello(@PathVariable String nome) {
        return "Boa noite " + nome;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody AppUser user) {
        if(user.getName().equals("emerson") &&
            user.getPassword().equals("1234")) {
                return ResponseEntity.ok("Acesso permitido");
            } else {
                return ResponseEntity.badRequest().build();
            }
    }
}
