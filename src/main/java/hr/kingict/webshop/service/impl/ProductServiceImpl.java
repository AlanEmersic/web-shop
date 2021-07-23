package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.repository.ProductRepository;
import hr.kingict.webshop.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product doesn't exist"));
    }

    @Override
    public List<Product> get(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
