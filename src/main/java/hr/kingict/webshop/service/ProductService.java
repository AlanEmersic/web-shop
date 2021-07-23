package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    Product get(Long id);

    List<Product> get(String name);

    List<Product> getAll();

    void delete(Product product);
}
