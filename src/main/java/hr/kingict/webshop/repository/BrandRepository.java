package hr.kingict.webshop.repository;

import hr.kingict.webshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByName(String name);
}
