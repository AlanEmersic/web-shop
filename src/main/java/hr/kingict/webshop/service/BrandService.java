package hr.kingict.webshop.service;

import hr.kingict.webshop.entity.Brand;

import java.util.List;

public interface BrandService {
    void save(Brand brand);

    Brand get(Long id);

    List<Brand> get(String name);

    List<Brand> getAll();

    void delete(Brand brand);
}
