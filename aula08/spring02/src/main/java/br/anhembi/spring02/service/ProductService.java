package br.anhembi.spring02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Optional<Product> create(Product product) {
        if (product.getCod() != 0) {
            return Optional.empty();
        }
        return Optional.of(repo.save(product));
    }

    public Optional<Product> update(Product product) {
        if (product.getCod() <= 0) {
            return Optional.empty();
        }
        Optional<Product> prodOptional = repo.findById(product.getCod());
        if (prodOptional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(repo.save(product));
    }

    public Optional<Product> updatePartial(Product product) {
        if (product.getCod() <= 0) {
            return Optional.empty();
        }
        Optional<Product> prodOptional = repo.findById(product.getCod());
        if (prodOptional.isEmpty()) {
            return Optional.empty();
        }

        Product productFound = prodOptional.get();

        if (product.getName() != null &&
                !product.getName().isBlank()) {
            productFound.setName(product.getName());
        }
        if (product.getValue() > 0) {
            productFound.setValue(product.getValue());
        }
        return Optional.of(repo.save(productFound));
    }

    public Optional<Product> findById(int id) {
        if (id <= 0) {
            return Optional.empty();
        }
        return repo.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) repo.findAll();
    }

    public boolean delete(int cod) {
        if (cod <= 0) {
            return false;
        }
        Optional<Product> prodOptional = repo.findById(cod);
        if (prodOptional.isEmpty()) {
            return false;
        }

        repo.deleteById(cod);
        return true;
    }

}
