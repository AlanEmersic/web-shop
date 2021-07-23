package hr.kingict.webshop.service.impl;

import hr.kingict.webshop.entity.Brand;
import hr.kingict.webshop.repository.BrandRepository;
import hr.kingict.webshop.service.BrandService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    @Transactional
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public Brand get(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("brand doesn't exist"));
    }

    @Override
    public List<Brand> get(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }
}
