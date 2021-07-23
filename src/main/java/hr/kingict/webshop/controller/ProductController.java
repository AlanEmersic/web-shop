package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.facade.ProductFacade;
import hr.kingict.webshop.form.ProductForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return productFacade.get(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productFacade.getAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody ProductForm productForm) {
        productFacade.create(productForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productFacade.delete(id);
    }
}
