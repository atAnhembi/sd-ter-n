package br.anhembi.spring02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        Optional<Product> optinalProduct = service.create(product);

        if (optinalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(optinalProduct.get(),
                HttpStatus.CREATED);
    }
    
    //atualização de todos os campos do produto
    @PutMapping 
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Optional<Product> optinalProduct = service.update(product);

        if (optinalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(optinalProduct.get(),
                HttpStatus.OK);
    }

    @PatchMapping 
    public ResponseEntity<Product> updatePartial(@RequestBody Product product) {
        Optional<Product> optinalProduct = service.updatePartial(product);

        if (optinalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(optinalProduct.get(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> optionalProduct = service.findById(id);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> produtos = service.findAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }
}
