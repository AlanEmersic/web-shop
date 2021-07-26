package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.ProductDto;
import hr.kingict.webshop.form.ProductForm;

import java.util.List;

public interface ProductFacade {
    void create(ProductForm productForm);

    ProductDto get(Long id);

    List<ProductDto> getAll(String sort);

    void delete(Long id);
}
